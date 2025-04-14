import java.util.HashSet;
import java.util.Set;

public class leetcode_1534 {
    public static void main(String[] args) {
        function1(new int[]{3,0,1,1,9,7}, 7, 2, 3);
    }

    public static void function1(int[] array, int a, int b, int c){
        int len = array.length;
        Set<int[]> set = new HashSet<>();
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(Math.abs(array[i] - array[j]) <= a && Math.abs(array[j] - array[k]) <= b && Math.abs(array[i] - array[k]) <= c){
                        set.add(new int[]{array[i], array[j], array[k]});
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}
