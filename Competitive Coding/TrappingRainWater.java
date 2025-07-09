public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = new int[]{4,2,0,3,2,5};
        int maxVol = function1(array);
        System.out.println("Maximum trap water: " + maxVol);

    }
    public static int function1(int[] array){
        try{
            int arrlen = array.length;
            int[] leftmax = new int[arrlen];
            leftmax[0] = array[0];
            for(int i=1;i<arrlen;i++){
                leftmax[i] = Math.max(array[i], leftmax[i-1]);
            }
            int[]rightmax = new int[arrlen];
            rightmax[arrlen - 1] = array[arrlen - 1];
            for(int i=arrlen-2;i>=0;i--){
                rightmax[i] = Math.max(rightmax[i+1], array[i]);
            }

            int maxVol = 0;
            for(int i=0;i<arrlen;i++){
                maxVol += Math.min(leftmax[i], rightmax[i]) - array[i];
            }
            return maxVol;


        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
