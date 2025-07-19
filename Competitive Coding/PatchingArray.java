public class PatchingArray {
    public static void main(String[] args) {
        int nums[] = {1,3};
        int target = 6;
        function1(nums, target);
    }

    public static void function1(int[] nums, int target){
        try{
            int miss = 1;
            int patch = 0;
            int i = 0;
            while (miss <= target) {
                if(i < nums.length && nums[i] <= miss){
                    miss += nums[i];
                    i++;
                }
                else{
                    miss *= 2;
                    patch++;
                }
            }
            
            System.out.println(patch);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
