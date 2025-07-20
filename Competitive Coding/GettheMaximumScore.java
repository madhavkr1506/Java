public class GettheMaximumScore {
    public static void main(String[] args) {
        int[] nums1 = {2,4,5,8,10}, nums2 = {4,6,8,9};
        int maxScore = function1(nums1, nums2);
        System.out.println("Max score: " + maxScore);

    }
    public static int function1(int[] nums1, int[] nums2){
        final int MOD = 1_000_000_007;
        try{
            int maxScore = 0;
            int sum1 = 0;
            int sum2 = 0;
            int len1 = nums1.length;
            int len2 = nums2.length;
            sum1 = 0;
            sum2 = 0;
            int i=0;
            int j=0;
            while (i < len1 && j < len2) {
                if(nums1[i] < nums2[j]){
                    sum1 += nums1[i];
                    i++;
                }
                else if(nums2[j] < nums1[i]){
                    sum2 += nums2[j];
                    j++;
                }else{
                    maxScore += Math.max(sum1, sum2) + nums1[i];
                    sum1 = 0;
                    sum2 = 0;
                    i++;
                    j++;
                }
                

            }
            while (i < len1) {
                sum1 += nums1[i++];
            }
            while (j < len2) {
                sum2 += nums2[j++];
            }
            maxScore += Math.max(sum1, sum2);
            return maxScore % MOD;


        }catch(Exception e){
            return -1;
        }
    }
}
