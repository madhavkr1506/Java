public class MaxSubArrSumDP {
    public static int maxsubarray(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for(int i=2;i<array.length;i++){
            dp[i] = Math.max(dp[i-1], array[i] + dp[i-2]);
        }
        return dp[array.length - 1];
    }
    public static void main(String[] args) {
        int[] array = {3, 2, 5, 10, 7};
        int result = maxsubarray(array);
        System.out.println("Maximum subarray sum is : " + result);
    }
}
