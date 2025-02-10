
public class leetcode_solution {

    public static void main(String[] args) {
        // System.out.println("LeetCode: ");
        // int value = 1000;
        // System.out.println(isPalindrome(value));
        // int value = 1534236469;
        // System.out.println(reverseNumber(value));
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(i)) {
                return 0;
            }
        }
        return 0;

    }


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
