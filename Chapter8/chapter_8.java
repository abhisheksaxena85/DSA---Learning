/*
    Starting the Recursion
    Start Date - February 24th, 2025 10:47 AM
 */

public class chapter_8 {

    public static void main(String args[]) {
        System.out.println("Hello World!");
        printValue(10);
    }

    /// Printing values from 1 to 10 using the recursive functions
    public static int printValue(int n) {
        // Base Case
        if (n == 1) {
            System.out.println("1");
            return 1;
        }
        System.out.println(n);
        return printValue(n - 1);
    }
}
