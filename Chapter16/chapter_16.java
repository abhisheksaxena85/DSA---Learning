
import java.util.Arrays;
import java.util.Comparator;

/*
    Starting Greedy Algorithm
    Start Date - June 16, 2025, 01:55 AM
 */
public class chapter_16 {

    public static void main(String[] ar) {
        // int startTime[] = {0, 1, 3, 5, 5, 8};
        // int endTime[] = {6, 2, 4, 7, 9, 9};
        // System.out.println(activities(startTime, endTime));
        // fractionalKnapSack();
        // minAbsoluteDifferencePair();
        // maxLength();

        int inCurr[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        minCoins(inCurr, 590);
    }

    /// Indian Coin or Canonical Coin System Problem
    public static void minCoins(int[] arr, int value) {
        int count = 0;
        int val = value;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= val) {
                while (arr[i] <= val) {
                    val = val - arr[i];
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // Max Length, Chain of Pairs
    public static void maxLength() {
        int arr[][] = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90}
        };

        Arrays.sort(arr, Comparator.comparing(a -> a[1]));
        int total = 1;
        int last = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= last) {
                last = arr[i][1];
                total++;
            }
        }
        System.out.println(total);
    }

    // Minimum Absolute Difference Pair
    public static void minAbsoluteDifferencePair() {
        int a[] = {4, 1, 8, 7};
        int b[] = {2, 3, 6, 5};
        Arrays.sort(a);
        Arrays.sort(b);
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            int pairDiff = a[i] - b[i];
            if (pairDiff < 0) {
                pairDiff *= -1;
            }
            total += pairDiff;
        }
        System.out.println(total);
    }

    // Fractional Knapsack Problem
    public static void fractionalKnapSack() {
        int weight[] = {10, 20, 30};
        int value[] = {60, 100, 120};
        int W = 60;

        double ratio[][] = new double[weight.length][2];
        for (int i = 0; i < weight.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / weight[i];
        }
        Arrays.sort(ratio, Comparator.comparing(O -> O[1]));

        double capacity = W;
        double totalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                totalValue += value[idx];
                capacity -= weight[idx];
            } else {
                totalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(totalValue);
    }

    public static int activities(int[] startTime, int[] endTime) {
        int arr[][] = new int[endTime.length][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = startTime[i];
            arr[i][2] = endTime[i];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index - " + arr[i][0] + " Start - " + arr[i][1] + " End - " + arr[i][2]);
        }
        Arrays.sort(arr, Comparator.comparing(val -> val[2]));
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index - " + arr[i][0] + " Start - " + arr[i][1] + " End - " + arr[i][2]);
        }

        int maxAct = 1;
        int last = arr[0][2];
        for (int i = 1; i < endTime.length; i++) {
            if (arr[i][1] >= last) {
                maxAct++;
                last = arr[i][2];
            }
        }

        return maxAct;
    }
}
