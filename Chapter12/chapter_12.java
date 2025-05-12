/*
    Starting ArrayList
    Start Date - May 04, 2025 Sunday 
 */

public class chapter_12 {

    public static void main(String args[]) {
        // int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // System.out.println(maxArea(arr));

        int arr[] = {11, 15, 6, 8, 9, 10};
        System.out.println(pairSum2(arr, 65498));

    }

    /// Pair Sum 2 - Find if any pair in a rotated and sorted array has the target sum
    public static boolean pairSum2(int arr[], int target) {
        int pivot = findPivotPoint(arr);
        int ei = pivot;
        int si = pivot + 1;
        while (si != ei) {
            int val = arr[si] + arr[ei];
            if (val == target) {
                return true;
            }

            if (val > target) {
                ei = (arr.length + ei - 1) % arr.length;
            } else {
                si = (si + 1) % arr.length;
            }
        }
        return false;
    }

    /// Finding the pivot point of array 
    public static int findPivotPoint(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }


/// Pair Sum 1 - Find if any pair in a sorted array has the target sum
    // public static boolean pairSum(int arr[], int target) {
    //     // for (int i = 0; i < arr.length; i++) {
    //     //     for (int j = i + 1; j < arr.length; j++) {
    //     //         if ((arr[i] + arr[j]) == target) {
    //     //             return true;
    //     //         }
    //     //     }
    //     // }
    //     // return false;
    //     int si = 0;
    //     int ei = arr.length - 1;
    //     while (si < ei) {
    //         if ((arr[si] + arr[ei]) == target) {
    //             return true;
    //         }

    //         if ((arr[si] + arr[ei]) < target) {
    //             si++;
    //         } else {
    //             ei--;
    //         }
    //     }
    //     return false;
    // }


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
