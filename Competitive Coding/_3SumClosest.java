import java.util.Arrays;

public class _3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(function1(nums, target));
    }

    public static int function1(int[] nums, int target){
        try{
            Arrays.sort(nums);
            int mindiff = Integer.MAX_VALUE;
            int closestSum = 0;
            for(int i=0;i<nums.length-2;i++){
                int left = i + 1;
                int right = nums.length - 1;
                
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == target){
                        return sum;
                    }
                    if(sum < target){
                        left++;
                    }
                    if(sum > target){
                        right--;
                    }
                    int diff = Math.abs(target - sum);
                    if(diff < mindiff){
                        mindiff = diff;
                        closestSum = sum;
                    }

                }
            }
            return closestSum;

        }catch(Exception e){
            return -1;
        }
    }
}
