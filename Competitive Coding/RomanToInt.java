import java.util.Scanner;

public class RomanToInt {
    public static int romanToInt(String s){
        int res = 0;
        for(int i=0;i<s.length();i++){
            int value1 = CharValue(s.charAt(i));
            if((i + 1) < s.length()){
                int value2 = CharValue(s.charAt(i + 1));
                if(value1 >= value2){
                    res += value1;
                }
                else{
                    res = res + value2 - value1;
                    i++;
                }
            }
            else{
                res = res + value1;
            }
        }
        return res;
    }
    public static int CharValue(char c){
        switch (c) {
            case 'I':
                
                return 1;
            case 'V':
                
                return 5;

            case 'X':
                
                return 10;
            case 'L':
                
                return 50;    
            case 'C':
                
                return 100;
            case 'D':
                
                return 500;
            case 'M':
                
                return 1000;
        
            default:
                return 0;
                
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(romanToInt("MCMIV"));
        sc.close();
    }
}
