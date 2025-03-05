import cv2
import mediapipe as mp
import numpy as np

# Initialize MediaPipe Hands module
mp_hands = mp.solutions.hands
mp_drawing = mp.solutions.drawing_utils
hands = mp_hands.Hands(min_detection_confidence=0.7, min_tracking_confidence=0.7)

# Function to calculate the distance between two points
def calculate_distance(p1, p2):
    return np.sqrt((p1.x - p2.x) ** 2 + (p1.y - p2.y) ** 2)

# Function to recognize hand gestures
def get_gesture(hand_landmarks):
    # Extract key finger landmarks
    thumb_tip = hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_TIP]
    thumb_ip = hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_IP]
    index_tip = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP]
    index_mcp = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_MCP]
    middle_tip = hand_landmarks.landmark[mp_hands.HandLandmark.MIDDLE_FINGER_TIP]
    middle_mcp = hand_landmarks.landmark[mp_hands.HandLandmark.MIDDLE_FINGER_MCP]
    ring_tip = hand_landmarks.landmark[mp_hands.HandLandmark.RING_FINGER_TIP]
    pinky_tip = hand_landmarks.landmark[mp_hands.HandLandmark.PINKY_TIP]

    # List of fingertip positions (excluding the thumb)
    fingers = [index_tip, middle_tip, ring_tip, pinky_tip]

    # Gesture recognition logic

    # Thumbs Up 👍
    if thumb_tip.y < thumb_ip.y and all(f.y > middle_mcp.y for f in fingers):
        return "Thumbs Up"

    # Thumbs Down 👎
    elif thumb_tip.y > thumb_ip.y and all(f.y > middle_mcp.y for f in fingers):
        return "Thumbs Down"

    # Open Hand ✋ (All fingers extended)
    elif all(f.y < middle_mcp.y for f in fingers) and thumb_tip.y < thumb_ip.y:
        return "Open Hand"

    # Fist ✊ (All fingers curled)
    elif all(f.y > middle_mcp.y for f in fingers) and calculate_distance(thumb_tip, index_tip) < 0.05:
        return "Fist"

    # Index Finger Up ☝️
    elif index_tip.y < index_mcp.y and all(f.y > middle_mcp.y for f in fingers[1:]):
        return "Index Finger Up"

    # Peace Sign ✌️ (Index and middle fingers extended)
    elif index_tip.y < index_mcp.y and middle_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in fingers[2:]):
        return "Peace Sign"

    # Rock Sign 🤘 (Index and pinky fingers extended)
    elif index_tip.y < index_mcp.y and pinky_tip.y < middle_mcp.y and all(f.y > middle_mcp.y for f in fingers[1:3]):
        return "Rock Sign"

    # OK Sign 👌 (Thumb and index finger touching)
    elif calculate_distance(thumb_tip, index_tip) < 0.05 and all(tip.y > middle_mcp.y for tip in [middle_tip, ring_tip, pinky_tip]):
        return "OK Sign"

    return "No Recognized Gesture"

# Open webcam
cap = cv2.VideoCapture(0)

while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        break  # Exit if the frame is not captured properly

    # Flip the frame horizontally (like a mirror)
    frame = cv2.flip(frame, 1)
    
    # Convert BGR to RGB (MediaPipe expects RGB input)
    rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Process frame with MediaPipe Hands
    results = hands.process(rgb_frame)

    if results.multi_hand_landmarks:
        for hand_landmarks in results.multi_hand_landmarks:
            # Draw hand landmarks on the frame
            mp_drawing.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)
            
            # Recognize gesture and display it
            gesture = get_gesture(hand_landmarks)
            cv2.putText(frame, gesture, (50, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

    # Show the output video with gestures detected
    cv2.imshow('Gesture Recognition', frame)

    # Press 'q' to exit the program
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release webcam and close windows
cap.release()
cv2.destroyAllWindows()