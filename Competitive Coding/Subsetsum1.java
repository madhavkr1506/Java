// time complexity : O(n x 2^n)

public class Subsetsum1 {

    public static void printAllSubarray(int[] array,int n){
        for(int i=0;i<(1<<n);i++){
            System.out.print("{ ");
            for(int j=0;j<n;j++){
                if((i & (1<<j)) != 0){
                    System.out.print(array[j]+" ");
                }
            }
            System.out.println(" }");
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,1};
        int n = array.length;
        printAllSubarray(array, n);

    }
}