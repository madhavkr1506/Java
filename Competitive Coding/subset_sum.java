public class subset_sum {

    public static boolean[][] dp;

    public static void printArray(){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean recu_subset_sum(int[] set, int n, int sum){

        if(sum == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(set[n - 1] > sum){
            return recu_subset_sum(set, n - 1, sum);
        }

        else{
            return recu_subset_sum(set, n - 1, sum) || recu_subset_sum(set, n - 1, sum - set[n - 1]);
        }

    }


    public static boolean dp_subset_sum(int[] set, int n, int sum){
        dp = new boolean[n + 1][sum + 1];

        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j] = false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(set[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int[] set = new int[]{3,34,4,12,5,2};
        int n = set.length;

        int sum = 9;

        // if(recu_subset_sum(set,n,sum)){
        //     System.out.println("Yes subset sum is there");
        // }

        if(dp_subset_sum(set, n, sum)){
            System.out.println("Yes subset sum is there");
        }


        printArray();

    }
}
