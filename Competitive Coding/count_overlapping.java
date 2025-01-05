import java.util.Arrays;

public class count_overlapping {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,5},{6,7}};

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int count = 0;
        int endTime = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < endTime){
                count++;
            }
            else{
                endTime = intervals[i][1];
            }
        }

        System.out.println("Overlapping count: " + count);
    }
}