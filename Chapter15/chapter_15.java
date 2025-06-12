/*
    Starting Queue
    Start Date - June 11, 2025, 3:51 PM
 */

public class chapter_15 {

    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Peek Value " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        System.out.println("Peek Value " + queue.peek());
        System.out.println("Size of queue " + queue.rear);

    }

    static class Queue {

        static int size; // size of queue
        int arr[];
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return rear == -1;
        }

        // Add new element in rear of queue
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is filled!");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Remove the front element from queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int frontVal = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return frontVal;
        }

        // Accessing first element of queue - as peek operation
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
}
