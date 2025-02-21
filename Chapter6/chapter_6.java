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
        // System.out.println("Bit at ith place " + getBit(5, 4)); 101
        // System.out.println("Value after updating the bit at ith place to 0: " + updateBit(5, 1, 1));
        // System.out.println("Claring the last bits : " + clearBits(15, 2));
        // System.out.println("Clearing the range of bits: " + clearRangeOfBits(10, 2, 4));
        System.out.println(isPowerOfTwo(98));
    }

    /// Checking if value is 2 to the power or not 
    public static String isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 ? "The value is power to the 2" : "The value is not power";
    }

    /// Clear range of bits 
    public static int clearRangeOfBits(int n, int i, int j) {
        int a = (~0) << (j + 1);
        int b = (1 << i) - 1;
        return n & (a | b);
    }

    /// Clearing the last bits of given number
    public static int clearBits(int n, int i) {
        return n & ((~0) << i);
    }

    /// Updating the ith bit 
    public static int updateBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        //     return clearBit(n, i);
        // } else {
        //     return setBit(n, i);
        // }
        clearBit(n, i);
        return n | (newBit << i);
    }

    /// Gettting the bit of the Ith place 
    public static int getBit(int n, int i) {
        int x = n & (1 << i);
        return x == 0 ? 0 : 1;
    }

    public static int setBit(int n, int i) {
        int x = n | (1 << i);
        return x;
    }

    public static int clearBit(int n, int i) {
        int x = n & (~(1 << i));
        return x;
    }


/// Finding out if value is Odd or even by calculating on the bit level
    // public static boolean isEven(int x){
    //     return (x&1)!=1;
    // }
}
