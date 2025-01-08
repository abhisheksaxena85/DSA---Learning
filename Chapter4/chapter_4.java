/*

    Starting 2D arrays chapter 

 */

public class chapter_4{
    public static void main(String[] args){
        final int mat[][] = {
           {1,2,3,4},
           {5,6,7,8},
           {9,10,11,12},
           {13,14,15,16},
        };

        for(int i = 0; i<mat.length; i++){
            for(int j= 0;j<mat[i].length;j++){
                System.err.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
