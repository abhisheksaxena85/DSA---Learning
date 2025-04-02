/*
    Starting backtracking
    Start Date - March 10, 2025 00:15 AM
 */

public class chapter_11 {

    public static void main(String args[]) {
        int arr[] = new int[5];

        // backtrackArr(arr, 0, 1);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]);
        // }
        // String str = "abc";
        // findSubset(str, 0, "");
        String str =  "abc";
        findPermutation(str, "");
    }

    /// Finding possible numbers of permutations of st
    public static void findPermutation(String str, String value) {
        if (str.length() == 0) {
            System.out.println(value);
            return;
        }

        for(int i = 0; i<str.length();i++){
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, value+str.charAt(i));
        }
    }


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
