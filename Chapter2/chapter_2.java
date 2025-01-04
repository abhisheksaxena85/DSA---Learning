

/* 
        Starting Array Data Structure
        start date - 5 Dec, 12:43 AM
 */

public class chapter_2 {

    public static void main(String[] value) {
        // int marks[] = {1,2,3,4,5,6};
        // int marks2[] = {1,2,3,4,5,6};
        // System.out.println(marks.equals(marks2[0]));

        // int marks2[] = {1,2,3,4,5,6};
        // int marks[] = {1,4,3};
        // marks[0] = 5;
        // marks[1] = 10;
        // marks[2] = 15;
        // System.out.println(Arrays.toString(marks));
        // ArrayList<Float> markValues = new ArrayList<>();
        // markValues.add(1.26f);
        // markValues.add(2.31f);
        // String val = markValues.toString();
        // System.out.println(markValues);
        // int limit = 120;
        // int val[] = new int[limit];
        /// Linear Search in Array
        // int numbers[] = {12, 123,2, 6, 98, 76, 56, 74, 78, 23, 52, 16, 9,4};
        // int searchedIndex = linearSearch(numbers, 2);
        // System.out.println(searchedIndex);
        

        // int numbers[] = {12, 123, 6, 98, 76, 56, 74, 78, 23, 52, 16, 9,4};
        // int smallestNumber = smallestNumber(numbers);
        // System.out.println("Smallest number : "+smallestNumber);


        /// Binary Search
        /// There must be a sorted array for binary search
        // Sorted Array 
        // int sortedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13};
        // // int foundValue = binarySearch(sortedArr, 90);
        // System.out.println("Found value :"+sortedArr.length);

        // int sortedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13};
        // reverseNumber(sortedArr);

        // for(int i = 0; i<=sortedArr.length-1;i++){
        //     System.err.print(" " + sortedArr[i]);
        // }
        // System.err.println("");

        /// Making Possible unique pairs in Array 
        // int array[] = {1,2,3,4,5, 6, 7, 8, 9,};
        // pairOfArray(array);

        /// Printing possible sub-arrays
        // int numbers[] = {1,-2,6,-1,3};
        // subArray(numbers);

        /// Getting Max value of sum of max sub-arrays
        // int numbers[] = {1,-2,6,-1,3};
        // maxValueOfSumOfSubArrayFromPrefix(numbers);

        // int numbers[] = {-2, -3, -4, -1, -2, -1, -5, -3};
        // kadanesAlgo(numbers);

        /// Trapped Water Area With Auxiliary Array
        int numbers[] = {4,2,0, 6, 3, 2, 5};
        int totalArea = trappedWaterArea(numbers);
        System.out.println("Total Area : " + totalArea);
    }

    public static int trappedWaterArea(int numbers[]){
        int totalWaterArea = 0;
        int n = numbers.length;

        /// Auxilary Array to store the left side max values
        int leftMax[] = new int[n];    
        leftMax[0] = numbers[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(numbers[i] ,leftMax[i-1]);
        }

        /// Auxilary Array to store the right side max values
        int rightMax[] = new int[n];
        rightMax[n-1] = numbers[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(numbers[i], rightMax[i+1]);
        }

        /// Now calculate the area of trapped water
        for(int i=0;i<n;i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            int trappedWater = waterLevel - numbers[i];
            totalWaterArea += trappedWater;
        }

        return totalWaterArea;
    }

    // public static void kadanesAlgo(int numbers[]){
    //     int maxSum = Integer.MIN_VALUE;
    //     int currentSum = 0;
    //     for(int i = 0; i<numbers.length;i++){
    //         currentSum = currentSum + numbers[i];
    //         if(currentSum<0){
    //             currentSum = 0;
    //         }
    //         if(maxSum < currentSum){
    //             maxSum = currentSum;
    //         }
    //     }
    //     System.out.println("Max Value : " + maxSum);
    // }
    // public static void maxValueOfSumOfSubArrayFromPrefix(int number[]){
    //     int currentSum;
    //     int maxValue = Integer.MIN_VALUE;
    //     int prefix[] = new int[number.length];
        
    //     prefix[0] = number[0];
    //     for(int i =1;i<=prefix.length-1;i++){
    //         prefix[i] += number[i];
    //     }

    //     for(int i = 0;i<=number.length;i++){
    //         for(int j = i; j<number.length; j++){
    //             currentSum = i==0? prefix[0] : prefix[j] - prefix[i-1];
    //             if(currentSum>maxValue){
    //                 maxValue = currentSum;
    //             }
    //         }
    //     }

    //     System.out.println("Max value :" + maxValue);
        
    // }


    // public static void subArray(int numbers[]){
    //     int currentValue = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     for(int i=0;i<=numbers.length-1;i++){
    //         for(int j = i; j<=numbers.length-1;j++){
    //             /// Printing each indivisual Array
    //             currentValue = 0;
    //             for(int k = i; k<=j;k++){
    //                 currentValue += numbers[k];
    //             }
    //             if(maxSum<currentValue){
    //                 maxSum = currentValue;
    //             }
    //             System.err.println("");
    //         }
    //             System.err.println("");
    //     }

    //     System.out.println("Max sum of sub-array: "+maxSum);
    // }

    // public static void pairOfArray(int array[]) {
    //     for (int i = 0; i <= array.length - 1; i++) {
    //         for (int j = i + 1; j <= array.length - 1; j++) {
    //             System.out.print("(" + array[i] + ", " + array[j] + "), ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void reverseNumber(int numbers[]){
    //     int first = 0, end = numbers.length-1;
    //     while(first<end){
    //         int temp = numbers[first];
    //         numbers[first] = numbers[end];
    //         numbers[end] = temp;
    //         first++;
    //         end--;
    //     } 
    // }
    // public static int binarySearch(int sortedArr[], int key){
    //     int start = 0;
    //     int end = sortedArr.length-1;
    //     while(start<=end){
    //         int mid = (start+end)/2;
    //         if(sortedArr[mid] == key){
    //             return mid;
    //         }else if(sortedArr[mid] > key){
    //             end = mid-1;
    //         }else{
    //             start = mid+1;
    //         }
    //     }
    //     return -1;
    // }
    // public static int smallestNumber(int numbers[]){
    //     int smallest = Integer.MAX_VALUE;
    //     for(int i = 0; i<numbers.length; i++){
    //         if(smallest > numbers[i]){
    //             smallest = numbers[i];
    //         }
    //     }
    //     return smallest;
    // }
    // public static int linearSearch(int numbers[], int key){
    //     for(int i = 0; i<numbers.length;i++){
    //         if(numbers[i] == key){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
