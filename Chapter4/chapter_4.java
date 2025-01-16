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
    // int matrix[][] = {
            // {1,2,3,4}, 
            // {5,6,7,8},
            // {9,10,11,12}, 
            // {13,14,15,16}
        //    {1,2,3,4,5},
        //    {1,2,3,4,5},
        //    {1,2,3,4,5},
        //    {1,2,3,4,5},
        //    {1,2,3,4,5},
        // };

        // System.out.println(diagonalSum(matrix));

        int matrix[][] = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}
        };

        searchKeyInSortedMatrix(matrix, 4);

    }
    
    public static boolean searchKeyInSortedMatrix(int matrix[][], int key){

        //! Brute Force Approach
        /// Time Complexity - O(n^2)
        /// Space Complexity - O(m*n)

        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[i].length;j++){
        //         if(matrix[i][j]==key){
        //             System.out.println("Key found at ("+i+", "+j+")");
        //         }
        //     }
        // }

        ///? Optimized Approach
        
        int row = 0;
        int col = matrix[0].length-1;


        while(row<matrix.length && col>=0 ){
            if(matrix[row][col]==key){
                System.out.println("Key found at ("+row+", "+col+")");
                return true;
            }else if(key>matrix[row][col]){
                row++;
            }else if(key<matrix[row][col]){
                col--;
            }
        }
        System.out.println("Not Found Key");
        return false;
    }


    // public static int diagonalSum(int matrix[][]) {
    //     int sum = 0;

        ///Brute Force Approach, But Working with Time Complexicity O(n^2)

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         // Primary Diagonal
        //         if (i == j) {
        //             sum = sum + matrix[i][j];
        //         }

        //         // Secondary Diagonal
        //         if (i + j == matrix.length - 1) {
        //             if (i != j) {
        //                 sum = sum + matrix[i][j];
        //             }

        //         }
        //     }
        // }


        /// Optimized Approach with Time Complexicity O(n) highly Optimized
    //     for(int i = 0; i<matrix.length;i++){
    //         // Primary Diagonal
    //         sum += matrix[i][i]; // when i == j
    //         // Secondary Diagonal
    //         if(i != matrix.length-1-i){ // When i != j
    //             sum += matrix[i][matrix.length-1-i];
    //         }
    //     }

    //     return sum;
    // }

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
