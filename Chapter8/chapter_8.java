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
        // System.out.println(fibonacci(48));
        
        /// Finding out if array is sorted or not
        // int value[] = {1, 2, 3, 23, 5};
        // System.out.println("Is sorted :" + isSorted(value, 0));

        /// Function to find the first Occurence of element in an array
        // int value[] = {1, 2, 3, 23, 5, 3, 4, 3, 5, 6, 7, 3};
        // System.out.println(lastIndex(value, 0, 3));

        /// Function to find the power of x^n using the recursion function
        // System.out.println("Value: " + xPowerN(2, 10));

        /// Function to find the power of x^n using the recursion function - Optimized Version
        System.out.println("Value: " + xPowerNOpt(2, 10));
    }

    public static int xPowerNOpt(int x, int n) {
        if (n == 1) { // Base base
            return x;
        }
        if (n % 2 == 0) {
            return xPowerNOpt(x, n / 2) * xPowerNOpt(x, n / 2);
        } else {
            return x * xPowerNOpt(x, (n - 1) / 2) * xPowerNOpt(x, (n - 1) / 2);
        }
    }


/// Find out the x^n using recursion
    // public static int xPowerN(int x, int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     return x * xPowerN(x, n - 1);
    // }


/// Find the last occurence of element in an array
    // public static int lastIndex(int data[], int i, int key) {
    //     // Base Case
    //     if (i == data.length) {
    //         return -1;
    //     }
    //     // Finding logic
    //     int foundValue = lastIndex(data, i + 1, key);
    //     if (key == data[i] && foundValue == -1) {
    //         return i;
    //     }
    //     return foundValue;
    // }

    /// Find the first occurence of an element in an array
    // public static int findIndex(int data[], int i, int key) {
    //     if (data.length - 1 == i) {
    //         return -1;
    //     }
    //     if (data[i] == key) {
    //         return i;
    //     }
    //     return findIndex(data, i + 1, key);
    // }


///Check if array is sorted or not using the recursion
    // public static boolean isSorted(int data[], int i) {
    //     if (i == data.length - 1) {
    //         return true;
    //     }
    //     if (data[i] > data[i + 1]) {
    //         return false;
    //     }
    //     return isSorted(data, i + 1);
    // }

    // Calculate the fibonacci of n number
    // public static long fibonacci(long n) {
    //     if (n == 0) {
    //         return 0;
    //     }
    //     if (n == 1) {
    //         return 1;
    //     }
    //     return fibonacci(n - 1) + fibonacci(n - 2);
    // }
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
