
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
        //     System.out.println(arr[i] + " ");
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // String str = "IceCreAm";
        // System.out.println(reverseVowels(str));
        String str = "a good   example";
        System.out.print(reverseWords(str));
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
    //     for (int i = 0; i < haystack.length(); i++) {
    //         if (haystack.charAt(i) == needle.charAt(i)) {
    //             return 0;
    //         }
    //     }
    //     return 0;
    // }

/// Reverse the input int value only in 32bit signed integer, If it crosses 32bit limit then return 0;
    // public static int reverseNumber(int x) {
    //     int a = x;
    //     long r = 0;
    //     if(x>0){
    //         while (a > 0) {
    //             int l = a % 10;
    //             a = a / 10;
    //             r = (r * 10) + l;
    //         }
    //     }else{
    //         while (a < 0) {
    //             int l = a % 10;
    //             a = a / 10;
    //             r = (r * 10) + l;
    //         }
    //     }
    //     if (r < 2147483648L && r > -2147483649L) {
    //         return (int) r;
    //     } else {
    //         return 0;
    //     }
    // }

    // public static boolean isPalindrome(Integer x) {
    //     int a = x;
    //     int r = 0;
    //     while (x > 0) {
    //         int l = x % 10;
    //         x = x / 10;
    //         r = (r * 10) + l;
    //     }
    //     if (a == r) {
    //         return true;
    //     }
    //     return false;
    // for(int i = 0; i<value.toString().length();i++){
    //     if(value.toString().charAt(i) != value.toString().charAt(value.toString().length()-1-i)){
    //         System.out.println("It is not palindrom");
    //         return false;
    //     }
    // }
    // System.out.println("It is palindrome");
    // return true;
    // }
}
