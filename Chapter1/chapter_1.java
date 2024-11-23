import java.util.*;

public class chapter_1{
    public static void main(String[] values){
        Scanner scan = new Scanner(System.in);
        // int valueInput = scan.nextInt();

        // while(valueInput > 0){
        //     int lastDigit = valueInput % 10;
        //     System.out.print(lastDigit);
        //     valueInput = (int)(valueInput/10);
        // }

        String value = scan.next();
        int intValue = scan.nextInt();
        String value2  = scan.next();
        System.out.print(value + intValue);
        System.out.print(value2);
    }
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

