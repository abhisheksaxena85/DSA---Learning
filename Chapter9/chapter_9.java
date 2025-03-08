/*
    Starting the Divide & Conquer
    Start Date - March 1st, 2025 01:30 AM
 */

public class chapter_9 {

    public static void main(String args[]) {

        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void mergeSort(int arr[], int startIndex, int endIndex) {
        // Base Case
        if (startIndex >= endIndex) {
            return;
        }

        // Recursion Work
        int mid = startIndex + (endIndex - startIndex) / 2;
        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        mergeArr(arr, startIndex, endIndex, mid);
    }

    public static void mergeArr(int arr[], int startIndex, int endIndex, int mid) {
        int temp[] = new int[endIndex - startIndex + 1];
        int counter = 0;
        int i = startIndex;
        int j = mid + 1;

        while (i <= mid && j <= endIndex) {
            if (arr[i] < arr[j]) {
                temp[counter] = arr[i];
                counter++;
                i++;
            } else {
                temp[counter] = arr[j];
                counter++;
                j++;
            }
        }

        while (i <= mid) {
            temp[counter++] = arr[i++];
        }

        while (j <= endIndex) {
            temp[counter++] = arr[j++];
        }

        for (i = startIndex, counter = 0; counter < temp.length; i++, counter++) {
            arr[i] = temp[counter];
        }
    }

}
