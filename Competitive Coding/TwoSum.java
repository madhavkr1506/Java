import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int target = 9;
        int[] result = function1(array, target);
        for(int i=0;i<result.length;i++){
            System.err.print(result[i] + " ");
        }

    }

    public static int[] function1(int[] array, int target){
        try{
            HashMap<Integer, Integer> temp = new HashMap<>();
            int index = -1;
            for(int num : array){
                index++;
                int rem = target - num;
                if(temp.containsKey(rem)){
                    
                    return new int[]{temp.get(rem), temp.getOrDefault(num, index)};
                }
                temp.put(num, index);
            }
            return new int[]{};
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new int[]{};
        }
    }
}
