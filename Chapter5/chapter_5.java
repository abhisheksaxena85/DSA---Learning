/*
    Starting Strings In Java
    Start Date - January 17th, 2025 12:34 AM
 */
public class chapter_5{
    public static void main(String[] arg){
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
        String route = "NS";
        findShortestPath(route);
    }

    /// Finding the shortest path when given route - [E, W, N, S]
    public static void findShortestPath(String route){
        int x=0,y=0;
        for(int i = 0; i<route.length(); i++){
            if(route.charAt(i) == 'E'){
                x++;
            }else if ( route.charAt(i) == 'W') {
                x--;
            }else if (route.charAt(i) == 'N'){
                y++;
            }else {
                y--;
            }
        }

        int xSq = x*x;
        int ySq = y*y;

        int shortestRoute = (int) Math.sqrt(xSq+ySq);

        System.out.println("The Shortest Path is : " + shortestRoute);
    }

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
