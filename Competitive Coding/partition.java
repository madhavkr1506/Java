import java.util.Scanner;

public class partition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[]{0,1,2,3,4};
        int n=array.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}