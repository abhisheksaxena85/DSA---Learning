/* 
        Starting Array Data Structure
        start date - 5 Dec, 12:43 AM
 */

public class chapter_2{
    public static void main(String[] value){
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

        int sortedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13};
        reverseNumber(sortedArr);

        for(int i = 0; i<=sortedArr.length-1;i++){
            System.err.print(" " + sortedArr[i]);
        }
        System.err.println("");
    }

    public static void reverseNumber(int numbers[]){
        int first = 0, end = numbers.length-1;

        while(first<end){
            int temp = numbers[first];
            numbers[first] = numbers[end];
            numbers[end] = temp;

            first++;
            end--;
        }

    }


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