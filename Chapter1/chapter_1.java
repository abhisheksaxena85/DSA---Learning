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
        
        int n = 20; 
        // Adding the loop
        for(int line = 1; line<=n; line++){
            for(int innerLine = 1; innerLine <= line; innerLine++){
                System.out.print(innerLine);
            }
            System.out.println();
        }
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
