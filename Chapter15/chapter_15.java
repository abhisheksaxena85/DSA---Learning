/*
    Starting Queue
    Start Date - June 11, 2025, 3:51 PM
 */

public class chapter_15 {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Queue queue = new Queue(4);
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
        static int front;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Add new element in rear of queue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is filled!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Check if queue is full 
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Remove the front element from queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int frontVal = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return frontVal;
        }

        // Accessing first element of queue - as peek operation
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
}
