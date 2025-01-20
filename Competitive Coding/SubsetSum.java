// time complexity :  O(2^n)
// space complexity : O(n)
public class SubsetSum {
    public static boolean subsetsum(int[] array,int n,int target){
        if(target == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(array[n-1]>target){
            return subsetsum(array, n-1, target);
        }

        return subsetsum(array, n-1, target) || subsetsum(array, n, target-array[n-1]);
    }
    public static void main(String[] args) {
        int[] array = {1,2,1};
        int n = array.length;
        int targetSum = 3;


        if(subsetsum(array, n, targetSum)){
            System.out.println("Subset sum is equal to target sum");
        }
        else{
            System.out.println("Subset sum is not equal to target sum");
        }

    }
}
