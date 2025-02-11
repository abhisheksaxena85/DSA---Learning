/*
    Starting bitwise operator chapter
    Start Date - January 29th, 2025 10:27 PM
 */

public class chapter_6 {

    public static void main(String[] args) {
        // int a = 5; 
        // int b = 2147483647; 
        // int c = a&b;   
        // System.err.println("Is value Even: "+isEven(11));
        System.out.println("Bit at ith place " + getBit(5, 4));
    }

    /// Gettting the bit of the Ith place 
    public static int getBit(int n, int i) {
        int x = n & (1 << i);
        return x == 0 ? 0 : 1;
    }


/// Finding out if value is Odd or even by calculating on the bit level
    // public static boolean isEven(int x){
    //     return (x&1)!=1;
    // }
}
