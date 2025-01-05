public class min_cost_to_reach_nth_city {
    public static void main(String[] args) {
        int[] array = {1,4,5,2};
        int n = array.length;

        int[] min_array = new int[n + 1];
        for(int i=0;i<=n;i++){
            min_array[i] = Integer.MAX_VALUE;
        }

        min_array[1] = 0;
        for(int i=1;i<=n;i++){
            if(i + 1 <= n){
                min_array[i + 1] = Math.min(min_array[i + 1],min_array[i] + Math.abs(array[i] - array[i - 1]));
            }
            if(i + 3 <= n){
                min_array[i + 3] = Math.min(min_array[i + 3],min_array[i] + Math.abs(array[i + 2] - array[i - 1]));
            }
        }

        System.out.println("Minimum cost: " + min_array[n]);
        
    }
}




