public class MatchstickstoSquare {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,2,2,};
        System.err.println(makesquare(array));
        
    }

    public static boolean makesquare(int[] nums){
        // TC: O(4^N)
        if(nums.length<4){
            return false;
        }
        int perimeter = findPerimeterOfSquare(nums);
        if(perimeter == 0 || perimeter % 4 != 0){
            return false;
        }
        int side = perimeter / 4;
        int[] sides = new int[]{side, side, side, side};
        return makesquarehelper(nums, 0, sides);

    }
    public static boolean makesquarehelper(int[]nums, int i, int[] sides){
        try{
            if(i == nums.length){
                return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
            }
            for(int j=0;j<4;j++){
                if(nums[i] > sides[j]){
                    continue;
                }
                sides[j] -= nums[i];
                if(makesquarehelper(nums, i + 1, sides)){
                    return true;
                }
                sides[j] += nums[i];
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public static int findPerimeterOfSquare(int[] array){
        try{
            int sum = 0;
            for(int i : array){
                sum += i;
            }
            return sum;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}