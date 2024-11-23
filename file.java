import java.util.Scanner;
class HackerRankQuestion {
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine(); 

        String value = scan.nextLine();

        System.out.println("String: " + value);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}