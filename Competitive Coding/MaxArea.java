import java.util.Scanner;

public class MaxArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of input you want to enter : ");

        int num = sc.nextInt();

        int[] array = new int[num];

        for(int i=0;i<num;i++){
            System.out.print((i + 1) + " height is : ");
            array[i] = sc.nextInt();
        }

        
        int maxarea = 0;
        for(int left = 0,right = array.length - 1;left < right;){
            maxarea = Math.max(maxarea, (right - left) * Math.min(array[left], array[right]));
            if(array[left] < array[right]){
                left++;
            }else{
                right--;
            }
        }

        System.out.println("Maximum area is : " + maxarea);

        sc.close();
    }
}
