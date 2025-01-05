// time complexity : O(N^2)

import java.util.Scanner;

public class PairSum {
    public static void printsubset(int[] array,int targetsum){
        
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j] == targetsum){
                    System.out.println("[ "+array[i]+" , "+array[j]+"]");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {1,2,1};
        int targetsum = 3;
        printsubset(array, targetsum);
        sc.close();

    }
}
