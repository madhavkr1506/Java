import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_interval {
    public static void main(String[] args) {
        int[][] interval = new int[][]{{1,3},{2,5},{12,15},{15,18}};

        Arrays.sort(interval, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merge_list = new ArrayList<>();
        merge_list.add(interval[0]);
        
        for(int i=1;i<interval.length;i++){
            int[] merge_time = merge_list.get(merge_list.size() - 1);
            if(interval[i][0] <= merge_time[1]){
                merge_time[1] = Math.max(merge_time[1], interval[i][1]);
            }else{
                merge_list.add(interval[i]);
            }
        }

        for(int[] list : merge_list){
            System.out.println(Arrays.toString(list));
        }


    }
}
