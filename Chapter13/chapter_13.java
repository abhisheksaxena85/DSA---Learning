/*
    Starting Linked-List
    Start Date - May 14, 2025, 1:00 AM
 */

public class chapter_13 {

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.printLinkedList();
        // ll.zigzag(ll.head);
        ll.printLinkedList();

        // System.out.println("Searched index Recursively: " + ll.searchRecursively(1));
        // System.out.println("Searched index " + ll.search(1));
        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // System.out.println(ll.isCycle());

        /// Applying Merge Sort to unsorted linkedlist
        // ll.printLinkedList();
        // ll.mergeSort(ll.head);
    }
}

class LinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

    /// Basic Node Structure
    public static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Addition in LinkedList is tow types - AddFirst, AddLast
    // - AddFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    // - AddLast
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // Add Function for LinkedList on any Given Index
    public void add(int index, int data) {
        Node newNode = new Node(data);
        int counter = 0;
        Node temp = head;
        if (index == 0) {
            addFirst(data);
            return;
        }
        while (counter < index - 1) {
            counter++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Print Linked List
    public void printLinkedList() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    /// Removing the Node out of list -
    // Remove First -
    public void removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is Empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    // Remove Last -
    public void removeLast() {
        if (size == 0) {
            System.out.println("Linked List is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }

    // Remove - any any given index
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        Node prev = head;
        Node curr = prev.next;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
    }

    public int search(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public int searchRecursively(int key) {
        return seachHelper(key, 0, head);
    }

    public int seachHelper(int key, int index, Node temp) {
        if (index == size) {
            return -1;
        } else if (temp.data == key) {
            return index;
        }
        return seachHelper(key, index + 1, temp.next);
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    /// Floyd's Cycle Finding Approach
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Cycle Found");
                isCycle = true;
                break;
            }
        }
        if (isCycle == true) {
            slow = head;
            // Corner Case - assign prev = head,
            // when connecting node is pointing to the head
            // as next not in the middle of node.
            Node prev = fast;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node rightHalf = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHalf);
        return merge(newLeft, newRight);
    }

    public Node merge(Node head, Node rightHalf) {
        Node mergedLL = new Node(0);
        Node temp = mergedLL;
        while (head != null && rightHalf != null) {
            if (head.data <= rightHalf.data) {
                temp.next = head;
                head = head.next;
                temp = temp.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
                temp = temp.next;
            }
        }

        while (head != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigzag(Node head) {
        Node mid = getMid(head);
        /// Reverse the right linkedlist
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node rh = prev;
        Node lh = head;
        Node nl, rl;
        /// Merge in zigzag order
        while (lh != null && rh != null) {
            nl = lh.next;
            rl = rh.next;
            lh.next = rh;
            rh.next = nl;

            /// Update the value
            lh = nl;
            rh = rl;
        }

    }
}
