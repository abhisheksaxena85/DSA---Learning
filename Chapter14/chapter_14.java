
import java.util.ArrayList;

/*
    Starting Stack
    Start Date - June 8, 2025, 1:24 AM
 */
public class chapter_14 {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("The stack is empty: " + s.isEmpty());
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println("The stack is empty: " + s.isEmpty());
    }
}

class Stack {

    /// Stack Using Array List
    ArrayList<Integer> list = new ArrayList<>();

    // Is Empty Function 
    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int peek() {
        return list.get(list.size() - 1);
    }

}
