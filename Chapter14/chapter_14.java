
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
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        //     System.out.println(span[i] + " ");
        // }
        // int arr[] = {6, 8, 0, 1, 3};
        // int result[] = nextGreater(arr);
        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }
        // String str = "((()){[]})]]][]][]";
        // System.out.println(validParanthesis(str));
        // String str = "((a+b)+(a+b))";
        // System.out.println(isDuplicateParanthesis(str));
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(arr));

    }

    /// Max Area in Histogram - Microsoft, Paytm, Facebook
    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int rightSmaller[] = smallerRight(arr);
        int leftSmaller[] = smallerLeft(arr);

        for (int i = 0; i < arr.length; i++) {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int area = width * arr[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static int[] smallerLeft(int[] arr) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] smallerRight(int[] arr) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    /// Duplicate Paranthesis - Google Microsoft
    public static boolean isDuplicateParanthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'b'
                    || ch == 'c' || ch == 'd'
                    || ch == '+' || ch == '-'
                    || ch == '*' || ch == '(') {
                stack.push(ch);
            } else {
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop();
                }
            }
        }
        return false;
    }

    /// Valid Paranthesis Problem
    public static boolean validParanthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((str.charAt(i) == ')' && stack.peek() == '(')
                        || str.charAt(i) == ']' && stack.peek() == '['
                        || str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /// Next Greater number Problem
    public static int[] nextGreater(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return result;
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
