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

        String name = "Mashroom-on-the-ground";
        operations(name);
    }

    /// Basic Operations on String 
    public static void operations(String stringValue){
        for(int i = 0;i<stringValue.length();i++){
            System.out.print(stringValue.charAt(i)+" ");
        }
    }
}