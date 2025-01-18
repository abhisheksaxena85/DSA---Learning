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
        int array[] = {1,2,3,4,5,2,4,3,7,5};

        int firstIndex = findFirstIndex(array, 5);
        System.out.println("First Index of Searched Value : " + firstIndex);
    }

    /// Method to find first index of seachvalue in the arrays
    public static int findFirstIndex(int array[], int searchValue){
        for(int i=0;i<array.length;i++){
            if(array[i] == searchValue){
                return i;
            }
        }
        return -1;
    }

    /// Basic Operations on String 
    // public static void operations(String stringValue){
    //     for(int i = 0;i<stringValue.length();i++){
    //         System.out.print(stringValue.charAt(i)+" ");
    //     }
    // }
}
