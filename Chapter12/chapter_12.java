/*
    Starting ArrayList
    Start Date - May 04, 2025 Sunday 
 */

public class chapter_12 {

    public static void main(String args[]) {
        // int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // System.out.println(maxArea(arr));

        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(pairSum(arr, 90));

    }

    /// Pair Sum 1 - Find if any pair in a sorted array has the target sum
    public static boolean pairSum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
                    return true;
                }
            }
        }
        return false;
    }


/// Container with most water - Leetcode Question Also
    // public static int maxArea(int[] h) {
    //     int a = Integer.MIN_VALUE;
    //     if (h.length == 0 || h.length == 1) {
    //         return 0;
    //     }
    //     int s = 0;
    //     int e = h.length - 1;
    //     while (s <= e) {
    //         int c = Math.min(h[s], h[e]) * (e - s);
    //         if (c > a) {
    //             a = c;
    //         }
    //         if (h[s] < h[e]) {
    //             s++;
    //         } else {
    //             e--;
    //         }
    //     }
    //     return a;
    // }

}
