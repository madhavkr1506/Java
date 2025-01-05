public class circular_array_maximum_sum {

    public static int max_circular_sum(int[] array, int n){
        int total_sum = 0;
        for(int i=0;i<n;i++){
            total_sum += array[i];
        }

        int minSumKadane = Integer.MAX_VALUE;
        int sum_ = 0; 
        for(int i=0;i<n;i++){
            sum_ += array[i];
            if(sum_ < minSumKadane){
                minSumKadane = sum_;
            }
            if(sum_ > 0){
                sum_ = 0;
            }
        }

        int circularSum = total_sum - minSumKadane;


        int maxSumKadane = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += array[i];
            if(sum > maxSumKadane){
                maxSumKadane = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }

        return Math.max(maxSumKadane, circularSum);


    }
    public static void main(String[] args) {
        int[] array = new int[]{8, -8, 9, -9, 10, -11, 12};
        int n = array.length;

        System.out.println("Max Circular Sum: " + max_circular_sum(array, n));
    }
}