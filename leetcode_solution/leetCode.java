

public class leetCode {
    public static void main(String args[]) {
        char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        reverseString(arr);
    }
    
    public static void reverseString(char[] s) {
        char newArr[] = new char[s.length];
        for (int i = s.length-1,j=0; i >= 0;j++, i--) {
            newArr[j] = s[i];
        }
        System.arraycopy(newArr, 0, s, 0, newArr.length);
    }
}
