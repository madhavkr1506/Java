import java.util.Arrays;

public class maximumtastenesscandy {
    public static void main(String[] args) {
        int[] array = new int[]{13,5,1,8,21,2};
        int k = 3;

        System.out.println("Maximum tasteness: " + function1(array, k));
    }

    public static int function1(int[] array, int k){
        Arrays.sort(array);
        int lowertaste = 0;
        int highertaste = array[array.length - 1] - array[0];
        int result = 0;
    
        while(lowertaste <= highertaste){
            int mid = (lowertaste) + (highertaste - lowertaste) / 2;
            if(helperfunction(array, mid,k)){
                result = mid;
                lowertaste = mid + 1;
            }else{
                highertaste = mid - 1;
            }
        }
    
        return result;
    }
    
    public static boolean helperfunction(int[] array, int mid, int k){
        int prev = array[0];
        int count = 1;

        for(int i=1;i<array.length;i++){
            if(array[i] - prev >= mid){
                count++;
                prev = array[i];
            }
        }

        if(count >= k){
            return true;
        }

        return false;
    }
}



