public class knapsack_01 {

    public static int rec_knapsack_01(int w, int[] wt, int[] val, int n){
        if(w == 0 || n == 0){
            return 0;
        }
        if(wt[n - 1] > w){
            return rec_knapsack_01(w, wt, val, n - 1);
        }
        else{
            return Math.max(rec_knapsack_01(w, wt, val, n - 1),val[n - 1] + rec_knapsack_01(w - wt[n - 1], wt, val, n - 1));
        }
    }


    public static int[][] dp_knapsack_01(int w, int[] wt, int[] val, int n){
        int[][] dp = new int[n + 1][w + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(wt[i - 1] <= j){
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]] , dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp;
    }
    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };

        int max_weight_ = 50;
        int n = profit.length;

        // int maximum_profit = rec_knapsack_01(max_weight_, weight, profit, n);
        // System.out.println("Maximum profit can be generated: " + maximum_profit);


        int[][] dp = new int[n + 1][max_weight_ + 1];
        dp = dp_knapsack_01(max_weight_, weight, profit, n);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
