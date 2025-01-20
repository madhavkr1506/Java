import java.util.Scanner;

public class IntegerToRoman {
    public static void makeRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanString = new StringBuilder();

        for(int i=0;i<values.length;i++){
            while(num >= values[i]){
                num -= values[i];
                romanString.append(symbols[i]);
            }
        }
        System.out.println("Roman Number = " + romanString.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 3541;
        makeRoman(num);
        sc.close();
    }
}
