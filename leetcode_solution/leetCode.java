
public class leetCode {

    public static void main(String args[]) {
        // char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        // reverseString(arr);
        // int image[][] = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        // flipAndInvertImage(image);
        // for (int row = 0; row < image.length; row++) {
        // for (int col = 0; col < image.length; col++) {
        // System.out.print(image[row][col] + " ");
        // }
        // System.out.println();
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
        // int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // System.out.println(trap(arr));
    }

    public static int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result = nums[i] | result;
            }
        }
        System.out.println(result);
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        merge(nums1, nums2, arr);

        // double result = 0.0;/
        if (arr.length % 2 != 0) {
            return (double) arr[arr.length / 2];
        } else {
            int mid = arr.length / 2;
            int median = arr[mid] + arr[mid - 1];
            return (double) median / 2;
        }
    }

    public int[] merge(int[] arr1, int[] arr2, int[] result) {
        int ptr1 = 0;
        int ptr2 = 0;
        int index = 0;

        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] < arr2[ptr2]) {
                result[index] = arr1[ptr1];
                ptr1++;
            } else {
                result[index] = arr2[ptr2];
                ptr2++;
            }
            index++;
        }

        while (ptr1 < arr1.length) {
            result[index] = arr1[ptr1];
            index++;
            ptr1++;
        }

        while (ptr2 < arr2.length) {
            result[index] = arr2[ptr2];
            index++;
            ptr2++;
        }

        return result;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode t = head.next;
        ListNode prev = head;
        // if (head == null && head.next == null) {
        // return head;
        // }
        while (t != null) {
            int divisor = findDivisor(prev.val, t.val);
            ListNode newNode = new ListNode(divisor);
            prev.next = newNode;
            newNode.next = t;
            t = t.next;
            prev = prev.next.next;
        }
        return head;
    }

    public static int findDivisor(int a, int b) {
        int val = a;
        int val2 = b;
        int divisor = 0;
        if (a < b) {
            val = b;
            val2 = a;
        }

        for (int i = 1; i <= val2; i++) {
            if (val % i == 0 && val2 % i == 0) {
                divisor = i;
            }
        }

        return divisor;
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }

        if (digits[0] == 10) {
            int arr[] = new int[digits.length + 1];
            arr[0] = 1;
            arr[1] = 0;
            for (int i = 2; i < digits.length; i++) {
                arr[i] = digits[i];
            }
            return arr;
        } else {
            return digits;
        }

    }

    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int counter = 1;
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix[0].length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Start Row
            for (int i = startCol; i <= endCol; i++) {
                matrix[startRow][i] = counter;
                counter++;
            }

            // End Column
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol] = counter;
                counter++;
            }

            // End Row
            for (int i = endCol - 1; i >= startCol; i--) {
                matrix[endRow][i] = counter;
                counter++;
            }

            // Start Col
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                matrix[i][startCol] = counter;
                counter++;
            }

            // Increase values
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return matrix;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode j = head;
        ListNode i = head.next;
        while (i != null) {
            if (i.val == j.val) {
                j.next = i.next;
                i = i.next;
            } else {
                i = i.next;
                j = j.next;
            }
        }
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (temp != null) {
            if (head.val == val) {
                head = head.next;
            }
            if (temp.val == val) {
                prev.next = temp.next;
                temp = temp.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        if (prev.val == 0) {
            return null;
        } else {
            return head;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
