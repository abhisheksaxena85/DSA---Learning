/*
    Starting Greedy Algorithm
    Start Date - June 16, 2025, 01:55 AM
 */

public class chapter_16 {

    public static void main(String[] ar) {
        int startTime[] = {1, 3, 0, 5, 8, 5};
        int endTime[] = {2, 4, 6, 7, 9, 9};
        System.out.println(activities(startTime, endTime));
    }

    public static int activities(int[] startTime, int[] endTime) {
        int maxAct = 1;
        int last = endTime[0];
        for (int i = 1; i < endTime.length; i++) {
            if (startTime[i] >= last) {
                maxAct++;
                last = endTime[i];
            }
        }

        return maxAct;
    }
}
