import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_970 {
    public static void main(String[] args) {
        System.out.println(function1(1, 6000, 4));
    }

    public static List<Integer> function1(long start, long end, int limit){
        Set<Integer> uniqueInteger = new HashSet<>();
        for (int i=0;i<20;i++){
            int x_power = (int)Math.pow(start, i);
            if (x_power > limit){
                break;
            }
            for(int j=0;j<20;j++){
                int y_power = (int)Math.pow(end, j);

                int sum = x_power + y_power;
                if(sum <= limit){
                    uniqueInteger.add(sum);
                }else{
                    break;
                }
                if (end == 1) break;
            }
            if (start == 1) break;
        }

        return new ArrayList<>(uniqueInteger);
    }
}
