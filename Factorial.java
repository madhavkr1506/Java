import java.util.Scanner;

public class Factorial {
    public static void factorial(int num){
        int i = 1;
        int fact = 1;
        while(i <= num){
            fact *= i;
            i++;
        }
        System.out.println("Factorial of number is: " + fact);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number : ");
        int num = sc.nextInt();

        factorial(num);
        sc.close();
    }
}
