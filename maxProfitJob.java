import java.util.Arrays;

public class maxProfitJob {

    static class jobs{
        int start;
        int finish;
        int income;
        jobs(int start, int finish, int income){
            this.start = start;
            this.finish = finish;
            this.income = income;
        }
    }

    public static int findLastNonOverlapping(jobs[] job, int index){
        int left = 0;
        int right = index - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid + 1 < job.length && job[mid].finish <= job[index].start){
                if(job[mid+1].finish <= job[index].start){
                    left = mid + 1;
                }
                return mid;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int maxProfit(jobs[] job){

        Arrays.sort(job, (a,b) -> a.finish - b.finish);
        int dp[] = new int[job.length];
        dp[0] = job[0].income;

        for(int i=1;i<job.length;i++){
            int includeIncome = job[i].income;
            int lastIndex = findLastNonOverlapping(job, i);
            if(lastIndex != -1){
                includeIncome += dp[lastIndex];
            }

            dp[i] = Math.max(dp[i-1], includeIncome);
        }

        return dp[job.length - 1];
    }
    public static void main(String[] args) {
        jobs job1 = new jobs(1, 3, 50);
        jobs job2 = new jobs(3, 5, 20);
        jobs job3 = new jobs(6, 19, 100);
        jobs job4 = new jobs(2, 100, 200);

        jobs[] job = new jobs[]{job1, job2, job3, job4};

        System.out.println("Maximum profit: " + maxProfit(job));
    }
}
