
public class practice_java {

    public static void main(String[] arguments) {
        // int value = reverseNumbers(8749655);
        // System.out.println(value);

        // isPrimeNumber(13);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int indexFound = binarySearch(arr, 8, 0, arr.length - 1);
        System.out.println("Index : " + indexFound);
    }

    /// Binary Search Algorithm - Practice
    public static int binarySearch(int arr[], int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        // Found on mid
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return binarySearch(arr, target, startIndex, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, endIndex);
        }

    }


/// Reversing the number in variable
    // public static int  reverseNumbers(int inputNumbers){
    //     int reversedValue = 0;
    //    while(inputNumbers>0){
    //         int lastDigit = inputNumbers % 10;
    //         reversedValue = (reversedValue *10) + lastDigit;
    //         inputNumbers = inputNumbers/10;
    //     }
    //     return reversedValue;
    // }


    /// Checking if value is prime or not
    // public static void  isPrimeNumber(int inputValue){
    //     for(int i = 2; i<=inputValue-1;i++){
    //         if(inputValue%i==0){
    //             System.out.println("IS PRIME");
    //         }else{
    //             System.out.println("NOT PRIME");
    //         }
    //     }
    // }
}
