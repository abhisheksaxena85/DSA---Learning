
import java.util.Scanner;

public class chapter_1 {

    public static void main(String[] values) {
        // Scanner scan = new Scanner(System.in);
        // int valueInput = scan.nextInt();
        // int reverse = 0;
        // while (valueInput > 0) {
        //     int lastDigit = valueInput % 10;
        //     reverse = (reverse * 10) + lastDigit;
        //     valueInput = (int) (valueInput / 10);
        // }
        // System.out.println(reverse);
        // String value = scan.next();
        // int intValue = scan.nextInt();
        // String value2  = scan.next();
        // System.out.print(value + intValue);
        // System.out.print(value2);
        // Scanner sc=new Scanner(System.in);
        //     System.out.println("================================");
        //     for(int i=0;i<3;i++){
        //         String s1=sc.next();
        //         int x=sc.nextInt();
        //         System.out.println(s1+""+x);
        //     }
        //     System.out.println("================================");
        // for(int i=4; i>=0; i--){
        //     for(int j= 1; j<=i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // for(int i=0; i<=4; i++){
        //     for(int j= 1; j<=i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        /// Printing Half Pyramid Pattern of Numbers
        
        // int n = 20; 
        // // Adding the loop
        // for(int line = 1; line<=n; line++){
        //     for(int innerLine = 1; innerLine <= line; innerLine++){
        //         System.out.print(innerLine);
        //     }
        //     System.out.println();
        // }


        // int n = 5;
        // char character = 'A';

        // for(int line = 1; line<=n ; line ++){
        //     for(int innterLine = 1; innterLine <= line; innterLine++){
        //         System.out.print(character);
        //         character++;
        //     }
        //     System.out.println();
        // }

/* 
==============================================================================
                      Starting Methods and Functions
==============================================================================
 */        

        // Calling the Custom Method or function
        // printHelloWorld();

        // Calling function with Parameter 
        // int valueOne = 34; 
        // int valueSecond = 234; 
        // int sum = AddValue(valueOne, valueSecond);
        // System.out.println("The sum of values is: "+sum);
        // int product = multiply(valueOne, valueSecond);
        // System.out.println("The product of values is: " + product);

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter value to get factorial: ");
        // int innputValue = sc.nextInt();
        // long factorial = factorial(innputValue);
        // System.out.println("The factorial value of input: " + factorial);

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter value of n: ");
        // int n = sc.nextInt();
        // System.out.print("Enter the value of r: ");
        // int r = sc.nextInt();

        // long biCoefficient = biCof(n, r);
        // System.out.println("BiCoefficient result of n & r: " + biCoefficient);

        // int a = 10;
        // int b = 12;
        // int c = 14;
        // int d = 16;
        
        // int sum = sum(a, b, c, d);
        // System.out.println("Sum is : "+sum);

        /// Checking if Entered Number through console, is prime or not

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the value: ");
        // int value = sc.nextInt();
        // for(int i = 2; i<=value-1; i++ ){
        //     if(value%i==0){
        //         System.out.println("Value is not a prime number");
        //         break;
        //     }else{
        //         System.out.println("Value is a prime number");
        //         break;
        //     }
        // }
        // sc.close();
        
        // Scanner sc = new Scanner(System.in);
        // int value = sc.nextInt();

        // System.out.println("Is this value is prime: "+isPrime(value));

        /// Printing all prime values from one to n
        // Scanner sc = new Scanner(System.in);
        // int value = sc.nextInt();
            
        // for(int i = 3; i<=value; i++ ){
        //     if(isPrime(i)){
        //         System.out.print(i+", ");
        //     }
        // }


        /// Converting the Decimal Numbers to Binary Numbers
        
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your input to convert into binary: ");
        // int input = sc.nextInt();
        // decimalToBinary(input);

        /// Converting the Binary Numbers into Decimal Number System
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter value through input: ");
        // int value = sc.nextInt();

        // binaryToDecimal(value);

        /// Printing a hollow rectangle
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter number of rows: ");
        // int rows = sc.nextInt();
        // System.out.print("Enter number of columns: ");
        // int column = sc.nextInt();

        // hollowRectangle(rows, column);

        /// Printing Half Inverted Pyramid
        // Scanner sc = new Scanner(System.in);

        // System.out.println("Enter number of lines: ");
        // int totalLine = sc.nextInt();
        // invertedHalfPyramid(totalLine);

        /// Printing Inverted Half pyramid with numbers
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number of lines: ");
        // int lines = sc.nextInt();
        // invertedHalfPyramidWithNumbers(lines);

        // Scanner sc = new Scanner(System.in);
        // int line = sc.nextInt();
        // floydTriangle(line); 


        /// 0 - 1 Triangle
        // Scanner sc = new Scanner(System.in);
        // int line = sc.nextInt();
        // zeroOneTriangle(line);


        /// Printing the Butterfly Pattern
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number of lines: ");
        // int value = sc.nextInt();
        // butterflyPattern(value);



        /// Printing Solid RhomBus
        // Scanner sc = new Scanner(System.in);
        // System.err.println("Enter numbers of line: ");
        // int value = sc.nextInt();
        // solidRhombus(value);


        /// Printing Hollow Rhombus
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of lines: ");
        int value = sc.nextInt();
        hollowRhombus(value);
    }

    static void hollowRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                if(i==n||j==n||i==1||j==1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // static void solidRhombus(int n){
    //     for(int i = 1; i<=n; i++){
    //         for(int j =1;j<= n-i;j++){
    //             System.out.print(" ");
    //         }
    //         for(int j = 1; j<=n; j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }
    // static void butterflyPattern(int n){
    //     for(int i = 1; i<=n; i++){
    //             for(int k =1; k<=i; k++){
    //                 System.out.print(" * ");
    //             }
    //             for(int l= 1; l<=2*(n-i);l++){
    //                 System.out.print("   ");
    //             }
    //             for(int k =1; k<=i; k++){
    //                 System.out.print(" * ");
    //             }
    //         System.out.println();
    //     }
    //     for(int i = n; i>=0; i--){
    //             for(int k =1; k<=i; k++){
    //                 System.out.print(" * ");
    //             }
    //             for(int l= 1; l<=2*(n-i);l++){
    //                 System.out.print("   ");
    //             }
    //             for(int k =1; k<=i; k++){
    //                 System.out.print(" * ");
    //             }
    //         System.out.println();
    //     }
    // }
    // static void zeroOneTriangle(int line){
    //     for(int i = 1; i<=line; i++){
    //         for(int j = 1; j<= i; j++){
    //             if((i+j)%2==0){
    //                 System.out.print(" 1 ");
    //             }else{
    //                 System.out.print(" 0 ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    // static void floydTriangle(int line){
    //     int counter = 1; 
    //     for(int i =1; i<=line; i++){
    //         for(int j =1; j<=i; j++){
    //             System.out.print(" "+counter);
    //             counter++;
    //         }
    //         System.out.println();
    //     }
    // }
    // static void invertedHalfPyramidWithNumbers(int lines){
    //     for(int i = 0; i<=lines-1; i++){
    //         for(int j = 1; j<=lines-i; j++){
    //             System.out.print(j);
    //         }
    //         System.out.println();
    //     }
    // }
    // static void invertedHalfPyramid(int totalLine) {
    //     for (int i = 1; i <= totalLine; i++) {
    //         // Print Empty Spaces
    //         for (int j = 1; j <= totalLine - i; j++) {
    //             System.out.print(" ");
    //         }
    //         // Print Stars
    //         for (int j = 1; j <= i; j++) {
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }
    // static void hollowRectangle(int rows, int column){
    //     for(int i = 1; i <= rows; i++){
    //         for(int j = 1; j<= column; j++){
    //             if(i==1|| i==rows|| j==1|| j==column){
    //                 System.out.print(" * ");
    //             }else{
    //                 System.out.print("   ");
    //             }
    //         }
    //         System.err.println("");
    //     }
    // }
    // static void binaryToDecimal(int inputValue){
    //     int power = 0;
    //     int decimal = 0;
    //     while(inputValue > 0){
    //         int lastDigit = inputValue %10;
    //         decimal= decimal+(int)(lastDigit * Math.pow(2, power));
    //         inputValue = inputValue/10;
    //         power++;
    //     }
    //     System.out.println("Output: " + decimal);
    // }
    // static void decimalToBinary(int inputValue){
    //     int remainder;
    //     int binary = 0;
    //     int power = 0; 
    //     while(inputValue > 0){
    //         remainder = inputValue % 2;
    //         binary = (int) (binary + remainder * Math.pow(10, power));
    //         inputValue = inputValue /2;
    //         power++;
    //     }
    //     System.out.println("Binary Code: "+binary); 
    // }

/// Checking if Value is prime or not
    // static boolean  isPrime(int value){
    //     boolean isPrimeNumber = true;
    //     for(int i= 2; i<= value-1; i++){
    //         if(value%i==0){
    //             isPrimeNumber = false ;
    //         }
    //     }
    //     return isPrimeNumber;
    // }


    /// Testing function or method overloading
    // static int sum(int a, int b){
    //     return a+b;
    // }

    // static int sum(int a, int b, int c){
    //     return a+b+c;
    // }
    
    // static int sum(int a, int b, int c, int d){
    //     return a+b+c+d;
    // }


    /// n!/{r!(n-r)!} - Mathematical Equation of Binomial Coefficient
    /// Calculating Binomial Coefficient
    // static long biCof(int n, int r){
    //     long biCoefficient = factorial(n)/(factorial(r) * factorial(n-r));
    //     return biCoefficient;
    // }


    // // Calculating factorial value through method
    // static long factorial(int value){
    //     long factorial = 1;
    //     for(int i = 1; i<=value; i++){
    //         factorial = factorial * i;
    //     }
    //     return factorial;
    // }

    // n = 1 * 2 * 3 * 4 * 5 * 6..........n


    // public static int AddValue(int a, int b){
    //     return a+b;
    // }

    // static int multiply(int param1, int param2){
    //     int product =  param1 * param2;
    //     return product;
    // }

    // public static int printHelloWorld(){
    //     System.out.println("Hello World From Void Method");
    //     return 0;
    // }
}

// public class chapter_1{
//     public static void main(String[] args){
//         // imageFile ojb = new imageFile();
//         //  imageFile2 ojb2 = new imageFile2();
//         // if( instanceof imageFile){
//         //     System.out.println("True");
//         // }else{
//         //     System.out.println("False");
//         // }
//         Scanner scanner = new Scanner(System.in);
//         String value = scanner.nextLine();
//         System.out.println(value);
//         // System.out.println("Enter String value now \n");
//         // // String input through terminal
//         // String value = scanner.nextLine();
//         // System.out.println(value);
//         // System.out.println("Enter int value now \n");
//         // // Int value input
//         // int intValue = scanner.nextInt();
//         // System.out.println(intValue);
//         // String value2= "Value to print";
//         for(int i=1; i<=4;i++)   {
//             for(int j=1;j<=5;j++){
//                 System.out.print("*");
//             }
//             System.out.print("\n");
//         }    
//     }
// }
// class imageFile{
//     void getImages(){
//         System.out.println("Everything worked out");
//     }
// }
// class imageFile2{
//     void getImages(){
//         System.out.println("Everything worked out");
//     }
// }

/*
    Value = 65489
    first = value % 10 = lastDigitOfValue
    syso(lastDigit);
    Double second = (int)(Value /10)

 */
