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
        // System.out.println("Value: " + xPowerNOpt(2, 10));

        /// Function to find ways in the tiling problem asked in Amazon
        // System.out.println("The number of ways: " + findWays(4));

        /// Function to remove the repeating characters in the string
        
        // System.out.println("New duplicate removed string value: " + deleteDuplicate("apnacollege", 0, new boolean[26], new StringBuilder("")));

        /// Function to findout number of ways to pair up given n friends
        // System.out.println(findWays(5));


        binaryValue(3, 0, "");
    }

    /// Binary String Problem - `*` [Paytm]
    /// Print All the binary strings of size N without consecutive ones.
    public static void binaryValue(int n, int lastIndex, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        binaryValue(n - 1, 0, str + "0");
        if (lastIndex == 0) {
            binaryValue(n - 1, 1, str + "1");
        }
    }


/// Friends Pairing problem - `*` [Goldman Sachs]
    /// Find the total number of ways in which friends can be paired up or can remain single, 
    /// Each friend can remain single
    // public static int findWays(int n) {
    //     if (n == 2 || n == 1) {
    //         return n;
    //     }
    //     return findWays(n - 1) + findWays(n - 1) * findWays(n - 2);
    // }


/// Remove the duplicate characters in a given string 
    // public static StringBuilder deleteDuplicate(String input, int index, boolean characters[], StringBuilder newStr) {
    //     // Base Case
    //     if (index == input.length()) {
    //         return newStr;
    //     }

    //     char charIndex = input.charAt(index);
    //     if (characters[charIndex - 'a'] == false) {
    //         characters[charIndex - 'a'] = true;
    //         return deleteDuplicate(input, index + 1, characters, newStr.append(charIndex));
    //     } else {
    //         return deleteDuplicate(input, index + 1, characters, newStr);
    //     }
    // }


/// Tiling Problem - `*`[Amazon]
    /// Find the Number of ways to fit the tiles in the 2*n area, where tile is 2*1
    /// And tiles can be added either vertically or horizontally
    // public static int findWays(int n) {
    //     // Base case
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }
    //     // Problem implementation
    //     //     Vertical          Horizontal 
    //     return findWays(n - 1) + findWays(n - 2);
    // }

    // public static int xPowerNOpt(int x, int n) {
    //     if (n == 1) { // Base base
    //         return x;
    //     }
    //     if (n % 2 == 0) {
    //         return xPowerNOpt(x, n / 2) * xPowerNOpt(x, n / 2);
    //     } else {
    //         return x * xPowerNOpt(x, (n - 1) / 2) * xPowerNOpt(x, (n - 1) / 2);
    //     }
    // }

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
