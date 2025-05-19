

public class leetCode {

    public static void main(String args[]) {
        // char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        // reverseString(arr);
        // int image[][] = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        // flipAndInvertImage(image);
        // for (int row = 0; row < image.length; row++) {
        //     for (int col = 0; col < image.length; col++) {
        //         System.out.print(image[row][col] + " ");
        //     }
        //     System.out.println();
        // }

        // ListNode ll = new ListNode(1);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // // ll.addLast(4);
        // // ll.addLast(5);
        // ll.printLinkedList();
        // removeNthFromEnd(ll.head, 1);
        // ll.printLinkedList();
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                area += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                area += rightMax - height[right];
            }
        }
        return area;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int s = 1;
        ListNode t = head;
        while (t.next != null) {
            t = t.next;
            s++;
        }

        if (s == n) {
            head = head.next;
            return head;
        }

        ListNode c = head;
        ListNode p = new ListNode(0);
        p.next = c;
        while (s != n) {
            c = c.next;
            p = p.next;
            s--;
        }
        p.next = c.next;
        return head;
    }

    public static void reverseString(char[] s) {
        char newArr[] = new char[s.length];
        for (int i = s.length - 1, j = 0; i >= 0; j++, i--) {
            newArr[j] = s[i];
        }
        System.arraycopy(newArr, 0, s, 0, newArr.length);
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < (image.length / 2); col++) {
                int value = image[row][col];
                image[row][col] = image[row][image.length - col - 1];
                image[row][image.length - col - 1] = value;
            }
        }
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image.length; col++) {
                if (image[row][col] == 0) {
                    image[row][col] = 1;
                } else {
                    image[row][col] = 0;
                }
            }
            System.out.println();
        }
        return image;
    }
}

class ListNode {

    int val;
    ListNode next;

    public static ListNode head;
    public static ListNode tail;
    int size = 0;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printLinkedList() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
