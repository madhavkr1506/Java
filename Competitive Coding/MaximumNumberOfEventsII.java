import java.util.Arrays;

public class MaximumNumberOfEventsII {
    public static void main(String[] args) {
        int[][] events = new int[][]{{1,2,4},{3,4,3},{2,3,1}};
        int k = 2;
        events = sortEventsOnEndDate(events);
        System.out.println("Max Value: " + dp_(events, k));
    }

    public static int[][] sortEventsOnEndDate(int[][] events){
        try{
            Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
            return events;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new int[][]{};
        }
    }

    public static int dp_(int[][] sortedEvents, int k){
        try{
            int rows = sortedEvents.length;
            int[][] dp = new int[rows + 1][k + 1];
            for(int i=1;i<=rows;i++){
                int[] currEvent = sortedEvents[i-1];
                int value = currEvent[2];
                int prev = findLastNonOverLapping(sortedEvents, i-1);
                for(int j=1;j<=k;j++){
                    dp[i][j] = dp[i-1][j];
                    int includeValue = value;
                    if(prev != -1){
                        includeValue += dp[prev+1][j-1];
                    }
                    dp[i][j] = Math.max(dp[i][j], includeValue);
                }
            }
            return dp[rows][k];
        }catch(Exception e){
            System.err.println(e.getMessage());
            return -1;
        }
    }
    public static int findLastNonOverLapping(int[][] sortedEvents, int currIndex){
        try{
            int low = 0;
            int high = currIndex - 1;
            int targetStart = sortedEvents[currIndex][0];
            while (low <= high) {
                int mid = (low + high) / 2;
                if(sortedEvents[mid][1] < targetStart){
                    if(mid == currIndex - 1 || sortedEvents[mid + 1][1] >= targetStart){
                        return mid;
                    }else{
                        low = mid + 1;
                    }
                }else{
                    high = mid - 1;
                }
            }
            return -1;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return -1;
        }
    }
}
