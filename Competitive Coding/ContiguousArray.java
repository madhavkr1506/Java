import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(function1(nums));
    }

    public static int function1(int[] nums){
        try{
            int len = 0;
            HashMap<Integer, Integer> hmap = new HashMap<>();
            int sum = 0;
            hmap.put(sum, -1);
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0){
                    sum += -1;
                }
                else{
                    sum += 1;
                }
                if(hmap.containsKey(sum)){
                    int lastIndex = hmap.get(sum); 
                    len = Math.max(len, i - lastIndex);
                }else{
                    hmap.put(sum, i);
                }
                
            }
            return len;


        }catch(Exception e){
            return -1;
        }
    }
}
