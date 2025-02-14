import java.util.Arrays;

public class house_robber {
    public static void main(String[] args) {
        int[] array = {1,2,3,1};

        System.out.println(function1(array));
    }

    public static int function1(int[] array){
        int[] dp = new int[array.length];
        Arrays.fill(dp, -1);

        int totalAmmount = helper(array, dp, 0);

        return totalAmmount;
    }

    public static int helper(int[] array, int[] dp, int index){

        if(index >= array.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int rob = array[index] + helper(array, dp, index + 2);

        int notrob = helper(array,dp, index + 1);

        return dp[index] = Math.max(rob,notrob);
    }
}
