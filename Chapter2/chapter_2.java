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
        int numbers[] = {12, 123,2, 6, 98, 76, 56, 74, 78, 23, 52, 16, 9,4};
        int searchedIndex = linearSearch(numbers, 2);
        System.out.println(searchedIndex);
        
    }

    public static int linearSearch(int numbers[], int key){
        for(int i = 0; i<numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
}