import java.util.Scanner;

public class PalindromicSubstring {
    public static boolean palindromicUtil(String str){
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) != str.charAt(n - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "1221";
        int n = str.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String substring = str.substring(i, j);
                if(palindromicUtil(substring)){
                    System.out.println(substring);
                }
            }
        }
        sc.close();
    }
}