/*
    Starting backtracking
    Start Date - March 10, 2025 00:15 AM
 */

public class chapter_11 {

    static int counter = 0;

    public static void main(String args[]) {
        // int arr[] = new int[5];

        // backtrackArr(arr, 0, 1);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]);
        // }
        // String str = "abc";
        // findSubset(str, 0, "");
        // String str =  "abc";
        // findPermutation(str, "");
        /// N-Queens -- Question
        char arr[][] = new char[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'x';
            }
        }
        nQueens(arr, 0);
        System.out.println(counter);
    }

    /// Placing N-Queens
    public static void nQueens(char[][] arr, int row) {
        if (arr.length == row) {
            counter++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, row, i) == true) {
                arr[row][i] = 'Q';
                nQueens(arr, row + 1);
                arr[row][i] = 'x';
            }
        }
    }

    public static boolean isSafe(char[][] arr, int row, int col) {
        /// Upward
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        /// Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        /// Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] arr) {
        System.out.println("---- Chess Board ----");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


/// N-Queens
    // Place N queens on an N*N chessboard such that no 2 queens can attack each other



    /// Finding possible numbers of permutations of st
    // public static void findPermutation(String str, String value) {
    //     if (str.length() == 0) {
    //         System.out.println(value);
    //         return;
    //     }

    //     for(int i = 0; i<str.length();i++){
    //         String newStr = str.substring(0, i) + str.substring(i+1);
    //         findPermutation(newStr, value+str.charAt(i));
    //     }
    // }


/// Printing all the subsets of an string
    // public static void findSubset(String str, int index, String value) {
    //     if (index == str.length()) {
    //         System.out.println(value);
    //         return;
    //     }

    //     findSubset(str, index + 1, value + str.charAt(index));
    //     findSubset(str, index + 1, value);
    // }

    // public static void backtrackArr(int arr[], int index, int value) {
    //     /// Base Case
    //     if (index == arr.length) {
    //         for (int i = 0; i < arr.length; i++) {
    //             System.out.print(arr[i]);
    //         }
    //         System.out.println();
    //         return;
    //     }
    //     arr[index] = value;
    //     backtrackArr(arr, index + 1, value + 1);
    //     arr[index] = value - 2;
    // }
}
