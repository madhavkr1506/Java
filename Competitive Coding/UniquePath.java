public class UniquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.err.println(uniquePath_(m, n));
        
    }

    public static int uniquePath_(int m, int n){
        try{
            int[][] dp = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            return dp[m-1][n-1];

        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
