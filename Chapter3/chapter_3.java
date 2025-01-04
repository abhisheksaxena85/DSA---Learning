/*
    Started Learning Sorting Algorithms
    Start Time -> 05-01-2025  01:38 AM
*/

class chapter_3{
    public static void main(String[] val){
        
        int unsortedArr[] = {9,3,4,6,7,1,8,44,34,11,98,89,5,0};
        bubbleSortAlgorithm(unsortedArr);
    }

    /// Bubble Sorting Algorithm
    public static void bubbleSortAlgorithm(int unsortedArr[]){
        /// Outer Loop
        for(int i = 0; i<=unsortedArr.length-1; i++){
            /// Inner Loop
            for(int j= 0; j<unsortedArr.length-1-i; j++){
                if(unsortedArr[j]>unsortedArr[j+1]){
                    /// Swap the variable
                    int temp = unsortedArr[j];
                    unsortedArr[j] = unsortedArr[j+1];
                    unsortedArr[j+1] = temp;
                }
            }
        }

        /// Printing Sorted Array
        for(int i = 0;i<=unsortedArr.length-1;i++){
            System.out.println(unsortedArr[i]);
        }
    }
}
