public class practice_java{
    public static void main(String[] arguments){
        // int value = reverseNumbers(8749655);
        // System.out.println(value);

        isPrimeNumber(13);
    }

    /// Reversing the number in variable
    // public static int  reverseNumbers(int inputNumbers){
    //     int reversedValue = 0;
    //    while(inputNumbers>0){
    //         int lastDigit = inputNumbers % 10;
    //         reversedValue = (reversedValue *10) + lastDigit;
    //         inputNumbers = inputNumbers/10;
    //     }
    //     return reversedValue;
    // }


    /// Checking if value is prime or not
    public static void  isPrimeNumber(int inputValue){
        for(int i = 2; i<=inputValue-1;i++){
            if(inputValue%i==0){
                System.out.println("IS PRIME");
            }else{
                System.out.println("NOT PRIME");
            }
        }
    }
}