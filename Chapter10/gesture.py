import cv2
import mediapipe as mp
import numpy as np
from deepface import DeepFace
from deepface.commons import functions

# Pre-load DeepFace models for emotion and gender analysis using functions.loadModel.
# This is the correct method for attribute models (emotion, gender, etc.)
model_emotion = functions.loadModel("Emotion")
model_gender = functions.loadModel("Gender")
models = {"emotion": model_emotion, "gender": model_gender}

# Initialize MediaPipe Hands and Face Detection modules
mp_hands = mp.solutions.hands
mp_face_detection = mp.solutions.face_detection
mp_drawing = mp.solutions.drawing_utils

hands = mp_hands.Hands(min_detection_confidence=0.7, min_tracking_confidence=0.7)
face_detection = mp_face_detection.FaceDetection(min_detection_confidence=0.7)

def map_emotion(emotion):
    """
    Map the detailed emotion from DeepFace to one of three categories:
    Anger, Happy, or Sad.
    """
    emotion = emotion.lower()
    if emotion in ["happy", "neutral", "surprise"]:
        return "Happy"
    elif emotion in ["angry"]:
        return "Anger"
    elif emotion in ["sad", "fear", "disgust"]:
        return "Sad"
    return emotion.capitalize()

def calculate_distance(p1, p2):
    return np.sqrt((p1.x - p2.x) ** 2 + (p1.y - p2.y) ** 2)

def get_gesture(hand_landmarks):
    thumb_tip = hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_TIP]
    thumb_ip = hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_IP]
    index_tip = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP]
    index_mcp = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_MCP]
    middle_tip = hand_landmarks.landmark[mp_hands.HandLandmark.MIDDLE_FINGER_TIP]
    middle_mcp = hand_landmarks.landmark[mp_hands.HandLandmark.MIDDLE_FINGER_MCP]
    ring_tip = hand_landmarks.landmark[mp_hands.HandLandmark.RING_FINGER_TIP]
    pinky_tip = hand_landmarks.landmark[mp_hands.HandLandmark.PINKY_TIP]

    fingers = [index_tip, middle_tip, ring_tip, pinky_tip]

    if thumb_tip.y < thumb_ip.y and all(f.y > middle_mcp.y for f in fingers):
        return "Thumbs Up"
    elif thumb_tip.y > thumb_ip.y and all(f.y > middle_mcp.y for f in fingers):
        return "Thumbs Down"
    elif all(f.y < middle_mcp.y for f in fingers) and thumb_tip.y < thumb_ip.y:
        return "Open Hand"
    elif all(f.y > middle_mcp.y for f in fingers) and calculate_distance(thumb_tip, index_tip) < 0.05:
        return "Fist"
    elif index_tip.y < index_mcp.y and all(f.y > middle_mcp.y for f in fingers[1:]):
        return "Index Finger Up"
    elif index_tip.y < index_mcp.y and middle_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in fingers[2:]):
        return "Peace Sign"
    elif index_tip.y < index_mcp.y and pinky_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in fingers[1:3]):
        return "Rock Sign"
    elif pinky_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in fingers[:3]):
        return "Washroom Sign"
    elif index_tip.y < index_mcp.y and pinky_tip.y < middle_mcp.y and thumb_tip.y < thumb_ip.y and all(f.y > middle_mcp.y for f in fingers[2:]):
        return "I Love You"
    elif middle_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in [index_tip, ring_tip, pinky_tip]):
        return "Middle Finger"
    elif pinky_tip.y < middle_mcp.y and thumb_tip.y < thumb_ip.y and all(f.y > middle_mcp.y for f in fingers[:3]):
        return "Call Me"
    elif calculate_distance(thumb_tip, index_tip) < 0.05 and all(tip.y > middle_mcp.y for tip in [middle_tip, ring_tip, pinky_tip]):
        return "OK Sign"
    return "No Recognized Gesture"

cap = cv2.VideoCapture(0)

while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        break

    # Mirror the frame for a natural selfie view.
    frame = cv2.flip(frame, 1)
    rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Process hand landmarks.
    hand_results = hands.process(rgb_frame)
    gesture = "No Hand Detected"
    if hand_results.multi_hand_landmarks:
        for hand_landmarks in hand_results.multi_hand_landmarks:
            mp_drawing.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)
            gesture = get_gesture(hand_landmarks)

    # Process face detection and analysis.
    face_results = face_detection.process(rgb_frame)
    emotion = "No Face Detected"
    gender = ""
    if face_results.detections:
        for detection in face_results.detections:
            bboxC = detection.location_data.relative_bounding_box
            ih, iw, _ = frame.shape
            x = int(bboxC.xmin * iw)
            y = int(bboxC.ymin * ih)
            w = int(bboxC.width * iw)
            h = int(bboxC.height * ih)

            cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
            face_roi = frame[y:y+h, x:x+w]
            if face_roi.size != 0:
                try:
                    # Analyze face ROI using DeepFace with pre-loaded models.
                    analysis = DeepFace.analyze(face_roi, actions=['emotion', 'gender'],
                                                models=models, enforce_detection=False)
                    dominant_emotion = analysis.get('dominant_emotion', 'N/A')
                    emotion = map_emotion(dominant_emotion)
                    gender = analysis.get('gender', 'N/A')
                except Exception as e:
                    emotion = "Error"
                    gender = "Error"

            # Draw a white info box with black text for emotion and gender.
            info_text = f"Emotion: {emotion} | Gender: {gender}"
            (text_width, text_height), _ = cv2.getTextSize(info_text, cv2.FONT_HERSHEY_SIMPLEX, 0.6, 2)
            box_y = y - 10 if y - 10 > text_height + 10 else y + h + text_height + 10
            cv2.rectangle(frame, (x, box_y - text_height - 10),
                          (x + text_width + 10, box_y), (255, 255, 255), -1)
            cv2.putText(frame, info_text, (x + 5, box_y - 5),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 0, 0), 2)

    # Combined info box at the top-left of the frame.
    combined_info = f"Gesture: {gesture} | Emotion: {emotion} | Gender: {gender}"
    (ci_width, ci_height), _ = cv2.getTextSize(combined_info, cv2.FONT_HERSHEY_SIMPLEX, 0.7, 2)
    cv2.rectangle(frame, (10, 10), (10 + ci_width + 10, 10 + ci_height + 10), (255, 255, 255), -1)
    cv2.putText(frame, combined_info, (15, 10 + ci_height),
                cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 0, 0), 2)

    cv2.imshow('Gesture, Emotion, and Gender Recognition', frame)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
