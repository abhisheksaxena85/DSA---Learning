/*
    Starting Strings In Java
    Start Date - January 17th, 2025 12:34 AM
 */
public class chapter_5 {

    public static void main(String[] arg) {
        // String name = "Abhishek Saxena";
        // System.out.println(name);
        // Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.nextLine();
        // System.err.println(name.contains("a"));

        // String name = "Mashroom-on-the-ground";
        // operations(name);
        /// Finding the first index of Seach - Value in the Array
        // int array[] = {1,2,3,4,5,2,4,3,7,5};

        // int firstIndex = findFirstIndex(array, 78);
        // System.out.println("First Index of Searched Value : " + firstIndex);

        // final String value = "Abhishek";
        // value = "Saxena";

        /// Find all the indexs as Unsorted Array of seached Value
        // int array[] = {1,2,3,4,5,2,4,3,7,5, 1, 3, 2, 2, 4, 7, 5, 55, 5};
        // int arr[] = findAllIndexs(array,2 );

        // for(int i = 0; i<arr.length;i++){
        //     System.out.print(arr[i] +" ");
        // }
        // System.err.println();

        /// Checking if entered string value is palindrome
        // String name = "abhishek";
        // System.err.println(isPalindrome(name));

        /// Finding the shortest path
        // String route = "NS";
        // findShortestPath(route);


        /// Finding the largest string lexicographically 
        // String name[] = {"abhishek", "mohit","deepu","saurabh","ankit"};

        // findLargest(name);

        // int nums[] = {3, 2, 4}, target = 6;

        // int values[] = twoSum(nums, target);

        // for (int i = 0; i < values.length; i++) {
        //     System.out.print(i + " ");
        // }

        // int value = 123;
        // System.err.println(isPalindrome(value));

        /// Making Input String's first letter uppercase
        // String str = "hello, i am abhishek saxena";
        // System.out.println(firstLetterUpperCase(str));

        /// Compressing the input string on repeating characters
        String value = "eeeetttttrrydd";
        System.out.println(stringCompression(value));
    }


    /// Method to make the string compressed when repeating
    public static String stringCompression(String value){
        String newStringValue = "";
        for(int i= 0; i<value.length();i++){
            Integer counter = 1;

            while(i<value.length()-1 && value.charAt(i) == value.charAt(i+1)){
                counter++;
                i++;
            }

            newStringValue += value.charAt(i);
            if(counter>1){
                newStringValue += counter.toString(); 
            }
        }
        return newStringValue;
    }

    /// First Letter UpperCase
    // public static String firstLetterUpperCase(String str){
    //     StringBuilder string = new StringBuilder();
        
    //     string.append(Character.toUpperCase(str.charAt(0)));

    //     for(int i = 1; i<str.length();i++){
    //         if(str.charAt(i) == ' ' && i<str.length()-1){
    //             string.append(' ');
    //             i++;
    //             string.append(Character.toUpperCase(str.charAt(i)));
    //         }else{
    //             string.append(str.charAt(i));
    //         }
    //     }

    //     return string.toString();
    // }

    // public static boolean isPalindrome(int x) {
    //     int originalvalue = x;
    //     int reversedNumber = 0;
    //     int power = 0;
    //     if(x==10){return false;}
    //     while (x > 0) {
    //         int lastDigit = x % 10;/// 12 -> 2

    //         x = x / 10; /// 12 -> 1
    //         reversedNumber = (int)(reversedNumber+(lastDigit * Math.pow(10, power))); /// 3
    //         power++; // 1
    //         System.out.println(reversedNumber); // 3
    //     }
    //     return originalvalue == reversedNumber;
    // }

    // public static int[] twoSum(int[] nums, int target) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i+1; j < nums.length; j++) {
    //             if ((nums[i] + nums[j]) == target) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return new int[]{};
    // }

/// Method to find the largest string value in the array 
    // public static void findLargest(String name[]){
    //     String largestString = "";
    //     for(int i = 0; i<name.length; i++){
    //         if(largestString.compareTo(name[i]) < 0){
    //             largestString = name[i];
    //         }
    //     }
    //     System.err.println("The largest name is lexicographically : " + largestString);
    // }

    /// Finding the shortest path when given route - [E, W, N, S]
    // public static void findShortestPath(String route){
    //     int x=0,y=0;
    //     for(int i = 0; i<route.length(); i++){
    //         if(route.charAt(i) == 'E'){ 
    //             x++;
    //         }else if ( route.charAt(i) == 'W') {
    //             x--;
    //         }else if (route.charAt(i) == 'N'){
    //             y++;
    //         }else {
    //             y--;
    //         }
    //     }

    //     int xSq = x*x;
    //     int ySq = y*y;

    //     int shortestRoute = (int) Math.sqrt(xSq+ySq);

    //     System.out.println("The Shortest Path is : " + shortestRoute);
    // }

    /// Method to check value, if it is palindrome 
    // public static boolean isPalindrome(String name){
    //     for(int i=0;i<name.length()/2; i++){
    //         if(name.charAt(i) != name.charAt(name.length()-1-i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    /// Find the all indexs of of seached Value as an unsorted Array
    // public static int[] findAllIndexs(int arr[], int searchedValue){
    //     int totalFoundIndexsLength =  0;
    //     for(int i = 0;i<arr.length;i++){
    //         if(arr[i] == searchedValue){
    //             totalFoundIndexsLength++;
    //         }
    //     }

    //     int seachedIndexs[] = new int[totalFoundIndexsLength];
    //     int index = 0;

    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i] == searchedValue){
    //             seachedIndexs[index] = i;
    //             index++;
    //         }
    //     }
    //     return seachedIndexs;
    // }

    /// Method to find first index of seachvalue in the arrays
    // public static int findFirstIndex(int array[], int searchValue){
    //     for(int i=0;i<array.length;i++){
    //         if(array[i] == searchValue){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    /// Basic Operations on String 
    // public static void operations(String stringValue){
    //     for(int i = 0;i<stringValue.length();i++){
    //         System.out.print(stringValue.charAt(i)+" ");
    //     }
    // }
}
