
public class leetcode_solution {

    public static void main(String[] args) {
        System.out.println("LeetCode: ");
        int value = 1000;
        System.out.println(isPalindrome(value));
    }

    public static boolean isPalindrome(Integer x) {
        int a = x;
        int r = 0;
        while (x > 0) {
            int l = x % 10;
            x = x / 10;
            r = (r * 10) + l;
        }
        if (a == r) {
            return true;
        }
        return false;

        // for(int i = 0; i<value.toString().length();i++){
        //     if(value.toString().charAt(i) != value.toString().charAt(value.toString().length()-1-i)){
        //         System.out.println("It is not palindrom");
        //         return false;
        //     }
        // }
        // System.out.println("It is palindrome");
        // return true;
    }
}
