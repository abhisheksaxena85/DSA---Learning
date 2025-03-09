/*
    Starting the Divide & Conquer
    Start Date - March 1st, 2025 01:30 AM
 */

public class chapter_9 {

    public static void main(String args[]) {

        // int arr[] = {6, 3, 9, 5, 2, 8};
        // mergeSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(" " + arr[i]);
        // }
        /// Quick Sort Algorithm
        // int arr[] = {5, 2, 3, 4, 1, 7};
        // quickSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(" " + arr[i]);
        // }

        /// Searching element on sorted & rotated array
        int arr[] = {6, 7, 8, 9, 0, 1, 3, 4, 5};
        int target = 9;
        int value = searchElement(arr, 0, arr.length - 1, target);
        System.out.println("index of value : " + value);
    }

    /// Searching element on sorted & rotated array
    public static int searchElement(int arr[], int startIndex, int endIndex, int target) {
        /// Base Case
        if (startIndex > endIndex) {
            return -1;
        }

        /// Recursion Work
        int mid = (startIndex + endIndex) / 2;

        /// Found on mid
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[startIndex] <= arr[mid]) {
            if (target >= arr[mid] && target <= arr[startIndex]) {
                return searchElement(arr, startIndex, mid - 1, target);
            } else {
                return searchElement(arr, mid + 1, endIndex, target);
            }
        } else {
            if (target >= arr[mid] && target <= arr[endIndex]) {
                return searchElement(arr, mid + 1, endIndex, target);
            } else {
                return searchElement(arr, startIndex, mid - 1, target);
            }
        }
    }


/// Quick Sort Algorithm
    // public static void quickSort(int arr[], int startIndex, int endIndex) {
    //     if (startIndex >= endIndex) {
    //         return;
    //     }

    //     int pvtIn = partition(arr, startIndex, endIndex);
    //     quickSort(arr, startIndex, pvtIn - 1); // Left Section
    //     quickSort(arr, pvtIn + 1, endIndex); // Right Section
    // }

    // public static int partition(int arr[], int startIndex, int endIndex) {
    //     int pvtIn = arr[endIndex];
    //     int i = startIndex - 1;

    //     for (int j = startIndex; j < endIndex; j++) {
    //         if (arr[j] <= pvtIn) {
    //             i++;
    //             int temp = arr[j];
    //             arr[j] = arr[i];
    //             arr[i] = temp;
    //         }
    //     }
    //     i++;
    //     int temp = arr[i];
    //     arr[i] = pvtIn;
    //     arr[endIndex] = temp;
    //     return i;
    // }


/// Merge Sort Algorithm
    // public static void mergeSort(int arr[], int startIndex, int endIndex) {
    //     // Base Case
    //     if (startIndex >= endIndex) {
    //         return;
    //     }

    //     // Recursion Work
    //     int mid = (endIndex + startIndex) / 2;
    //     mergeSort(arr, startIndex, mid);
    //     mergeSort(arr, mid + 1, endIndex);
    //     mergeArr(arr, startIndex, endIndex, mid);
    // }

    // public static void mergeArr(int arr[], int startIndex, int endIndex, int mid) {
    //     int temp[] = new int[endIndex - startIndex + 1];
    //     int counter = 0;
    //     int i = startIndex;
    //     int j = mid + 1;

    //     while (i <= mid && j <= endIndex) {
    //         if (arr[i] < arr[j]) {
    //             temp[counter] = arr[i];
    //             counter++;
    //             i++;
    //         } else {
    //             temp[counter] = arr[j];
    //             counter++;
    //             j++;
    //         }
    //     }

    //     while (i <= mid) {
    //         temp[counter++] = arr[i++];
    //     }

    //     while (j <= endIndex) {
    //         temp[counter++] = arr[j++];
    //     }

    //     for (i = startIndex, counter = 0; counter < temp.length; i++, counter++) {
    //         arr[i] = temp[counter];
    //     }
    // }

}
