
import java.util.Stack;

/*
    Starting Stack
    Start Date - June 8, 2025, 1:24 AM
 */
public class chapter_14 {

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);

        // reverseStack(s);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // System.out.println("The stack is empty: " + s.isEmpty());
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // System.out.println("The stack is empty: " + s.isEmpty());
        // String a = "Hello World";
        // System.out.println(reverseString(a));
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            while (!stack.isEmpty() && stocks[i] > stocks[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack(stack);
        pushToBottom(stack, top);
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String result = "";
        while (!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
        }
        return result;
    }

    public static void pushToBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int topData = stack.peek();
        stack.pop();
        pushToBottom(stack, data);
        stack.push(topData);
    }
}

// class Stack {
//     /// Stack using LinkedList
//     static Node head;
//     public boolean isEmpty() {
//         return head == null;
//     }
//     public void push(int data) {
//         Node newNode = new Node(data);
//         if (isEmpty()) {
//             head = newNode;
//             return;
//         }
//         newNode.next = head;
//         head = newNode;
//     }
//     public void pop() {
//         if (isEmpty()) {
//             System.out.println("Stack is empty");
//             return;
//         }
//         head = head.next;
//     }
//     public int peek() {
//         if (isEmpty()) {
//             System.out.println("Stack is empty");
//             return -1;
//         }
//         return head.data;
//     }
//     /// Stack Using Array List
//     ArrayList<Integer> list = new ArrayList<>();
//     // Is Empty Function 
//     public boolean isEmpty() {
//         return list.size() == 0;
//     }
//     public void push(int data) {
//         list.add(data);
//     }
//     public void pop() {
//         list.remove(list.size() - 1);
//     }
//     public int peek() {
//         return list.get(list.size() - 1);
//     }
//     public class Node {
//         int data;
//         Node next;
//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }
// }
