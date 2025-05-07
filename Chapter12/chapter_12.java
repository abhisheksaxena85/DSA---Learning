/*
    Starting ArrayList
    Start Date - May 04, 2025 Sunday 
 */

public class chapter_12 {

    public static void main(String args[]) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    /// Container with most water - Leetcode Question Also
    public static int maxArea(int[] h) {
        int a = Integer.MIN_VALUE;
        if (h.length == 0 || h.length == 1) {
            return 0;
        }
        int s = 0;
        int e = h.length - 1;
        while (s <= e) {
            int m = Math.min(h[s], h[e]);
            int d = e - s;
            int c = m * d;
            if (c > a) {
                a = c;
            }
            if (h[s] < h[e]) {
                s++;
            } else {
                e--;
            }
        }
        return a;
    }

}
