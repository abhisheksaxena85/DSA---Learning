
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    Starting Queue
    Start Date - June 11, 2025, 3:51 PM
 */
public class chapter_15 {

    public static void main(String[] args) {
        // Stack queue = new Stack();
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // queue.add(4);

        // System.out.println("Peek Value " + queue.peek());
        // while (!queue.isEmpty()) {
        //     System.out.println(queue.remove());
        // }
        // queue.remove();
        // System.out.println("Peek Value " + queue.peek());
        // System.out.println("Size of queue " + queue.size());
        // String str = "aabccxb";
        // firstNonRepeatingChar(str);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        reverseQueue(q);
    }

    /// Reversing the queue
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.add(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

    /// Interleave tow halves of a queue
    public static void interLeave(Queue<Integer> q) {
        int halfSize = q.size() / 2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        while (halfSize > 0) {
            q1.add(q.remove());
            halfSize--;
        }

        while (!q1.isEmpty() && !q.isEmpty()) {
            result.add(q1.remove());
            result.add(q.remove());
        }

        while (!result.isEmpty()) {
            System.out.println(result.remove());
        }

    }

    public static void firstNonRepeatingChar(String str) {
        Queue<Character> queue = new LinkedList<>();
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int charIndex = ch - 'a';
            arr[charIndex] += 1;
            queue.add(ch);
            while (!queue.isEmpty()) {
                if (arr[queue.peek() - 'a'] > 1) {
                    queue.remove();
                } else {
                    System.out.print(queue.peek() + " ");
                    break;
                }
            }

            if (queue.isEmpty()) {
                System.out.print(-1 + " ");
            }
        }
    }
    // static class Node {
    //     int data;
    //     Node next;
    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack {
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();
    //     public boolean isEmpty() {
    //         return q1.isEmpty() && q2.isEmpty();
    //     }
    //     public void add(int data) {
    //         if (!q1.isEmpty()) {
    //             while (!q1.isEmpty()) {
    //                 q2.add(q1.remove());
    //                 if (q1.isEmpty()) {
    //                     break;
    //                 }
    //             }
    //             q1.add(data);
    //             while (!q2.isEmpty()) {
    //                 q1.add(q2.remove());
    //                 if (q2.isEmpty()) {
    //                     break;
    //                 }
    //             }
    //         } else {
    //             while (!q2.isEmpty()) {
    //                 q1.add(q2.remove());
    //                 if (q2.isEmpty()) {
    //                     break;
    //                 }
    //             }
    //             q2.add(data);
    //             while (!q1.isEmpty()) {
    //                 q2.add(q1.remove());
    //                 if (q1.isEmpty()) {
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     public int remove() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         if (!q1.isEmpty()) {
    //             return q1.remove();
    //         } else {
    //             return q2.remove();
    //         }
    //     }
    //     public int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         if (!q1.isEmpty()) {
    //             return q1.peek();
    //         } else {
    //             return q2.peek();
    //         }
    //     }
    // }
    // static class Queue {
    //     Stack<Integer> s1 = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();
    //     public boolean isEmpty() {
    //         return s1.isEmpty();
    //     }
    //     public void add(int data) {
    //         s1.push(data);
    //     }
    //     public int remove() {
    //         if (s1.isEmpty()) {
    //             return -1;
    //         }
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         int val = s2.pop();
    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //         return val;
    //     }
    //     public int peek() {
    //         if (s1.isEmpty()) {
    //             return -1;
    //         }
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         int val = s2.peek();
    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //         return val;
    //     }
    //     //     static Node front = null;
    //     //     static Node rear = null;
    //     //     public boolean isEmpty() {
    //     //         return front == null && rear == null;
    //     //     }
    //     //     public void add(int data) {
    //     //         Node newNode = new Node(data);
    //     //         if (front == null) {
    //     //             front = rear = newNode;
    //     //             return;
    //     //         }
    //     //         rear.next = newNode;
    //     //         rear = newNode;
    //     //     }
    //     //     public int remove() {
    //     //         if (isEmpty()) {
    //     //             return -1;
    //     //         }
    //     //         int val = front.data;
    //     //         if (rear == front) {
    //     //             rear = front = null;
    //     //         } else {
    //     //             front = front.next;
    //     //         }
    //     //         return val;
    //     //     }
    //     //     public int peek() {
    //     //         if (isEmpty()) {
    //     //             return -1;
    //     //         }
    //     //         return front.data;
    //     //     }
    //     // static int size; // size of queue
    //     // int arr[];
    //     // static int rear;
    //     // static int front;
    //     // public Queue(int n) {
    //     //     arr = new int[n];
    //     //     size = n;
    //     //     rear = -1;
    //     //     front = -1;
    //     // }
    //     // // Check if queue is empty
    //     // public boolean isEmpty() {
    //     //     return rear == -1 && front == -1;
    //     // }
    //     // // Add new element in rear of queue
    //     // public void add(int data) {
    //     //     if (isFull()) {
    //     //         System.out.println("Queue is filled!");
    //     //         return;
    //     //     }
    //     //     if (front == -1) {
    //     //         front = 0;
    //     //     }
    //     //     rear = (rear + 1) % size;
    //     //     arr[rear] = data;
    //     // }
    //     // // Check if queue is full 
    //     // public boolean isFull() {
    //     //     return (rear + 1) % size == front;
    //     // }
    //     // // Remove the front element from queue
    //     // public int remove() {
    //     //     if (isEmpty()) {
    //     //         System.out.println("Queue is empty");
    //     //         return -1;
    //     //     }
    //     //     int frontVal = arr[front];
    //     //     if (front == rear) {
    //     //         front = rear = -1;
    //     //     } else {
    //     //         front = (front + 1) % size;
    //     //     }
    //     //     return frontVal;
    //     // }
    //     // // Accessing first element of queue - as peek operation
    //     // public int peek() {
    //     //     if (isEmpty()) {
    //     //         System.out.println("Queue is empty");
    //     //         return -1;
    //     //     }
    //     //     return arr[front];
    //     // }
    // }
}
