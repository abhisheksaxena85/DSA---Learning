
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_solution {

    public static void main(String[] args) {
        // System.out.println("LeetCode: ");
        // int value = 1000;
        // System.out.println(isPalindrome(value));
        // int value = 1534236469;
        // System.out.println(reverseNumber(value));
        // System.out.println(strStr("hello", "ll"));

        // /// Roman to int
        // System.out.println("Roman to int : " + romanToInt("MCMXCIV"));
        // String str = "hello";
        // System.out.println(scoreOfString(str));
        // String s = "ctoyjrwtngqwt";
        // int k = 8;
        // char fill = 'n';
        // String arr[] = divideString(s, k, fill);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i] + " ");
        // }
        // for (int i = 0; i < nums.length; i++) {
        // System.out.print(nums[i] + " ");
        // }
        // String str = "IceCreAm";
        // System.out.println(reverseVowels(str));
        String str = "a good   example";
        System.out.print(reverseWords(str));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return path(root, targetSum, 0);
    }

    public static boolean path(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) {
            return true;
        }
        boolean left = path(root.left, target, sum);
        boolean right = path(root.right, target, sum);

        return left || right;
    }

    static int total = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        total += root.val;
        root.val = total;
        bstToGst(root.left);
        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            if (root1 == null) {
                return root2;
            } else {
                return root1;
            }
        }

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    ArrayList<Integer> arr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(0, arr.size() - 1);
    }

    public TreeNode buildTree(int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;

        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(si, mid - 1);
        root.right = buildTree(mid + 1, ei);
        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) { // Right side traversal
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) { // Left side traversal
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        ArrayList<TreeNode> arr1 = new ArrayList<>();
        ArrayList<TreeNode> arr2 = new ArrayList<>();

        getPath(root, p, arr1);
        getPath(root, q, arr2);
        int i = 0;
        for (; i < arr1.size() && i < arr2.size(); i++) {
            if (arr1.get(i).val != arr2.get(i).val) {
                break;
            }
        }

        return arr1.get(i - 1);
    }

    public static boolean getPath(TreeNode root, TreeNode node, ArrayList<TreeNode> arr) {
        if (root == null) {
            return false;
        }

        arr.add(root);

        if (root.val == node.val) {
            return true;
        }

        boolean left = getPath(root.left, node, arr);
        boolean right = getPath(root.right, node, arr);
        if (left || right) {
            return true;
        }
        arr.remove(arr.size() - 1);
        return false;
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // Edge Cases
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            arr.add(t.val);
            t = t.next;
        }

        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        for (int i = 1; i < arr.size(); i++) {
            ListNode newNode = new ListNode(arr.get(i - 1));
            ListNode newNode1 = new ListNode(arr.get(i));
            temp.next = newNode1;
            temp.next.next = newNode;
            temp = temp.next.next;
            i++;
        }

        if (arr.size() % 2 != 0) {
            ListNode newNode = new ListNode(arr.remove(arr.size() - 1));
            temp.next = newNode;
        }
        return listNode.next;
    }

    public static String reverseWords(String s) {
        String arr[] = s.split(" ");
        int pt1 = 0;
        int pt2 = arr.length - 1;
        while (pt1 < pt2) {
            if (arr[pt1] == "") {
                pt1++;
            } else if (arr[pt2] == "") {
                pt2--;
            } else {
                String t = arr[pt1];
                arr[pt1] = arr[pt2];
                arr[pt2] = t;
                pt1++;
                pt2--;
            }
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != "") {
                result += arr[i];
                if (i != arr.length - 1) {
                    result += " ";
                }
            }
        }
        return result;
    }

    public static String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int pt1 = 0;
        int pt2 = arr.length - 1;

        while (pt1 < pt2) {
            if (isVowel(arr[pt1]) == false) {
                pt1++;
            } else {
                if (isVowel(arr[pt2]) == true) {
                    char t = arr[pt2];
                    arr[pt2] = arr[pt1];
                    arr[pt1] = t;
                    pt1++;
                    pt2--;
                } else {
                    pt2--;
                }
            }
        }

        return new String(arr);
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1_temp = list1;
        ListNode list1_next = list1.next;

        for (int i = 1; i < a; i++) {
            list1_temp = list1_temp.next;
            list1_next = list1_temp.next;
        }

        list1_temp.next = list2;

        for (int i = 0; i < (b + 1 - a); i++) {
            list1_next = list1_next.next;
        }
        ListNode list2_temp = list2;
        while (list2_temp.next != null) {
            list2_temp = list2_temp.next;
        }
        list2_temp.next = list1_next;

        return list1;
    }

    public static void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;
        while (temp.next != null) {
            temp.val = temp.next.val;
            prev = temp;
            temp = temp.next;
        }

        if (temp.next == null) {
            prev.next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode t = list;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                int lastDigit = sum % 10;
                ListNode newNode = new ListNode(lastDigit);
                t.next = newNode;
                carry = 1;
            } else {
                ListNode newNode = new ListNode(sum);
                t.next = newNode;
                carry = 0;
            }
            t = t.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum > 9) {
                int lastDig = sum % 10;
                carry = 1;
                ListNode newNode = new ListNode(lastDig);
                t.next = newNode;
            } else {
                ListNode newNode = new ListNode(sum);
                t.next = newNode;
                carry = 0;
            }
            t = t.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum > 9) {
                int lastDig = sum % 10;
                ListNode newNode = new ListNode(lastDig);
                t.next = newNode;
            } else {
                ListNode newNode = new ListNode(sum);
                t.next = newNode;
                carry = 0;
            }
            t = t.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(1);
            t.next = newNode;
            t = t.next;
        }

        return list.next;
    }

    public static String[] divideString(String s, int k, char fill) {
        int resultLength = s.length() % k == 0 ? s.length() / k : (s.length() / k) + 1;
        String result[] = new String[resultLength];

        String sbStr = "";
        String leftStr = s;

        for (int i = 0; i < result.length; i++) {
            if (leftStr.length() < k) {
                sbStr = leftStr;
                for (int j = sbStr.length(); j < k; j++) {
                    sbStr += fill;
                }
            } else {
                sbStr = leftStr.substring(0, k);
                leftStr = leftStr.substring(k, leftStr.length());
            }
            result[i] = sbStr;
            System.out.println("Sub String " + sbStr);
            System.out.println("Left Str " + leftStr);
            System.out.println();
        }

        return result;
    }

    public static String reversePrefix(String word, char ch) {
        int index = 0;
        Stack<Character> stack = new Stack<>();
        String sbStr = word.substring(0, word.indexOf(ch) + 1);
        String leftStr = word.substring(word.indexOf(ch) + 1, word.length());
        while (index < sbStr.length()) {
            stack.push(sbStr.charAt(index));
            index++;
        }

        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        result += leftStr;
        return result;
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            char ch[] = words[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int searchInsert(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        int mid = 0;
        while (si <= ei) {
            mid = (si + ei) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return si;
    }

    public static int scoreOfString(String s) {
        int val = 0;
        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i), b = s.charAt(i - 1);
            int sum = b - a;
            if (sum < 0) {
                sum = sum * -1;
            }
            val += sum;
        }
        return val;
    }

    public static int romanToInt(String s) {
        int v = 0;
        int c = s.length() - 1;
        int pv = 0;

        while (c >= 0) {
            // first time execution
            if (c == s.length() - 1) {
                v = getValue(s.charAt(c));
                pv = getValue(s.charAt(c));
            } else {
                if (getValue(s.charAt(c)) >= pv) {
                    v += getValue(s.charAt(c));
                    pv = getValue(s.charAt(c));
                } else {
                    v -= getValue(s.charAt(c));
                    pv = getValue(s.charAt(c));
                }
            }
            c--;
        }
        return v;
    }

    public static int getValue(char roVal) {
        switch (roVal) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    // public static int strStr(String haystack, String needle) {
    // for (int i = 0; i < haystack.length(); i++) {
    // if (haystack.charAt(i) == needle.charAt(i)) {
    // return 0;
    // }
    // }
    // return 0;
    // }

    /// Reverse the input int value only in 32bit signed integer, If it crosses
    /// 32bit limit then return 0;
    // public static int reverseNumber(int x) {
    // int a = x;
    // long r = 0;
    // if(x>0){
    // while (a > 0) {
    // int l = a % 10;
    // a = a / 10;
    // r = (r * 10) + l;
    // }
    // }else{
    // while (a < 0) {
    // int l = a % 10;
    // a = a / 10;
    // r = (r * 10) + l;
    // }
    // }
    // if (r < 2147483648L && r > -2147483649L) {
    // return (int) r;
    // } else {
    // return 0;
    // }
    // }

    // public static boolean isPalindrome(Integer x) {
    // int a = x;
    // int r = 0;
    // while (x > 0) {
    // int l = x % 10;
    // x = x / 10;
    // r = (r * 10) + l;
    // }
    // if (a == r) {
    // return true;
    // }
    // return false;
    // for(int i = 0; i<value.toString().length();i++){
    // if(value.toString().charAt(i) !=
    // value.toString().charAt(value.toString().length()-1-i)){
    // System.out.println("It is not palindrom");
    // return false;
    // }
    // }
    // System.out.println("It is palindrome");
    // return true;
    // }
}
