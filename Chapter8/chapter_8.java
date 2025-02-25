/*
    Starting the Recursion
    Start Date - February 24th, 2025 10:47 AM
 */

public class chapter_8 {

    public static void main(String args[]) {
        // System.out.println("Hello World!");
        // printValue(10);
        // printValuesToN(10);

        /// Finding out the facotrial
        // System.out.println(factorial(6));

        /// Calculating the sum of n numbers
        // System.out.println(sum(10));

        /// Calculate the fibonacci of n number
        System.out.println(fibonacci(8));
    }

    // Calculate the fibonacci of n number
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Calculating the sum of first n natural numbers 
    // public static int sum(int n) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     return n + sum(n - 1);
    // }
    // Printing the factorial of number n
    // public static int factorial(int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     return n * factorial(n - 1);
    // }

/// Printing values from 1 to n
    // public static void printValuesToN(int n) {
    //     if (n == 1) {
    //         System.out.println(n);
    //         return;
    //     }
    //     printValuesToN(n - 1);
    //     System.out.println(n);
    // }


/// Printing values from 1 to 10 using the recursive functions
    // public static void printValue(int n) {
    //     // Base Case
    //     if (n == 1) {
    //         System.out.println("1");
    //         return;
    //     }
    //     System.out.println(n);
    //     printValue(n - 1);
    // }
}
