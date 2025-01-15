/*

    Starting 2D arrays chapter 
    Start Date - January 9th, 2025 12:05 AM

 */

public class chapter_4 {

    public static void main(String[] args) {
        //     final int mat[][] = {
        //        {1,2,3,4},
        //        {5,6,7,8},
        //        {9,10,11,12},
        //        {13,14,15,16},
        //     };

        //     for(int i = 0; i<mat.length; i++){
        //         for(int j= 0;j<mat[i].length;j++){
        //             System.err.print(mat[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        /// Spriral Matrix Problem, asked in Google, Amazon, Oracle, Apple, Microsoft
    // int matrix[][] = {
    //     {1,2,3,4},
    //     {5,6,7,8},
    //     {9,10,11,12},
    //     {13,14,15,16}
    // };
    // spiralMatrix(matrix);

    /// Diagonal Sum of Matrix
    int matrix[][] = {
            // {1,2,3,4}, 
            // {5,6,7,8},
            // {9,10,11,12}, 
            // {13,14,15,16}
           {1,2,3,4,5},
           {1,2,3,4,5},
           {1,2,3,4,5},
           {1,2,3,4,5},
           {1,2,3,4,5},
        };

        System.out.println(diagonalSum(matrix));

    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Primary Diagonal
                if (i == j) {
                    sum = sum + matrix[i][j];
                }

                // Secondary Diagonal
                if (i + j == matrix.length - 1) {
                    if (!(i == j)) {
                        sum = sum + matrix[i][j];
                    }

                }
            }
        }

        return sum;
    }

    // public static void spiralMatrix(int matrix[][]){
    //     int startRow = 0;
    //     int startCol = 0;
    //     int endRow = matrix.length-1;
    //     int endCol = matrix[0].length-1;
    //     while(startRow<=endRow && startCol<=endCol){
    //         /// Top
    //         for(int i=startCol; i<=endCol;i++){
    //             System.out.print(matrix[startRow][i]+" ");
    //         }
    //         /// Right
    //         for(int j = startRow+1;j<=endRow;j++){
    //             System.out.print(matrix[j][endCol]+" ");
    //         }
    //         /// Bottom
    //         for(int i=endCol-1; i>=startCol;i--){
    //             System.out.print(matrix[endRow][i]+" ");
    //         }
    //         /// Left
    //         for(int j = endRow-1;j>=startRow+1;j--){
    //             System.out.print(matrix[j][startCol]+" ");
    //         }
    //         startCol++;
    //         endCol--;
    //         startRow++;
    //         endRow--;
    //     }
    //     // for(int i=0;i<matrix.length;i++){
    //     //     for(int j=0;j<matrix[i].length;j++){
    //     //         System.out.print(matrix[i][j] +" ");
    //     //     }
    //     //     System.err.println();
    //     // }
    // }
}
