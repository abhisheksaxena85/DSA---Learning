



public class leetCode {
    public static void main(String args[]) {
        // char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        // reverseString(arr);
        int image[][] = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        flipAndInvertImage(image);
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image.length; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public static void reverseString(char[] s) {
        char newArr[] = new char[s.length];
        for (int i = s.length - 1, j = 0; i >= 0; j++, i--) {
            newArr[j] = s[i];
        }
        System.arraycopy(newArr, 0, s, 0, newArr.length);
    }
    
    public static  int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < (image.length / 2); col++) {
                int value = image[row][col];
                image[row][col] = image[row][image.length - col - 1];
                image[row][image.length - col - 1] = value;
            }
        }
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image.length; col++) {
                if (image[row][col] == 0) {
                    image[row][col] = 1;
                } else {
                    image[row][col] = 0;
                }
            }
            System.out.println();
        }
        return image;
    }
}
