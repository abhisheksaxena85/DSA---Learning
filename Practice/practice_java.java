
public class practice_java {

    public static void main(String[] arguments) {
        // int value = reverseNumbers(8749655);
        // System.out.println(value);

        // isPrimeNumber(13);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int indexFound = binarySearch(arr, 8);
        System.out.println("Index : " + indexFound);
    }

    /// Binary Search Algorithm - Practice
    public static int binarySearch(int arr[], int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2; // Mid value
            if (arr[mid] == target) { // When found on mid
                return mid;
            }

            if (arr[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
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
