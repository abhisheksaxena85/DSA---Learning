
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
        String str = "hello";
        System.out.println(scoreOfString(str));
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
