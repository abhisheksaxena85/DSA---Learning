/*
    Starting backtracking
    Start Date - March 10, 2025 00:15 AM
 */

public class chapter_11 {

    public static void main(String args[]) {
        int arr[] = new int[5];

        backtrackArr(arr, 0, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void backtrackArr(int arr[], int index, int value) {
        /// Base Case
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        arr[index] = value;
        backtrackArr(arr, index + 1, value + 1);
        arr[index] = value - 2;
    }
}
