/*
    Started Learning Sorting Algorithms
    Start Time -> 05-01-2025  01:38 AM
*/

class chapter_3{
    public static void main(String[] val){
        
        // int unsortedArr[] = {9,3,4,6,7,1,8,44,34,11,98,89,5,0};
        // bubbleSortAlgorithm(unsortedArr);
 
        int unsortedArr[] = {9,3,4,6,7,1,8,44,34,11,98,89,5,0};
        selectionSort(unsortedArr);
        

    }

    /// Selection Sorting Algorithm
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;  
        }
        for(int i = 0;i<=arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }


    // /// Bubble Sorting Algorithm
    // public static void bubbleSortAlgorithm(int unsortedArr[]){
    //     /// Outer Loop
    //     for(int i = 0; i<=unsortedArr.length-1; i++){
    //         /// Inner Loop
    //         for(int j= 0; j<unsortedArr.length-1-i; j++){
    //             if(unsortedArr[j]>unsortedArr[j+1]){
    //                 /// Swap the variable
    //                 int temp = unsortedArr[j];
    //                 unsortedArr[j] = unsortedArr[j+1];
    //                 unsortedArr[j+1] = temp;
    //             }
    //         }
    //     }

    //     /// Printing Sorted Array
    //     for(int i = 0;i<=unsortedArr.length-1;i++){
    //         System.out.println(unsortedArr[i]);
    //     }
    // }
}
