/*
    Starting bitwise operator chapter
    Start Date - January 29th, 2025 10:27 PM
 */

public class chapter_6{
    public static void main(String[] args){
        int a = 5; 
        int b = 2147483647; 
        int c = a&b;   
        System.err.println("Is value Even: "+isEven(11));
    }

    /// Finding out if value is Odd or even by calculating on the bit level
    public static boolean isEven(int value){
        return (value&1) != 1;
    }
}