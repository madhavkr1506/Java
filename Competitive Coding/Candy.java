import java.util.Arrays;
import java.util.stream.Collectors;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int minimumCandies = function1(ratings);
        System.out.println("Minimum candies: " + minimumCandies);
    }

    public static int function1(int[] ratings){
        try{
            int len = ratings.length;
            int[] candies = new int[len];
            Arrays.fill(candies, 1);
            for(int i=0;i<len;i++){
                if(i > 0){
                    if(ratings[i] > ratings[i-1]){
                        candies[i] = candies[i-1] + 1;
                    }
                }
            }
            for(int j=len-2;j>=0;j--){
                if(ratings[j] > ratings[j+1]){
                    candies[j] = Math.max(candies[j], candies[j+1] + 1);
                }
            }

            System.out.println(Arrays.stream(candies).boxed().collect(Collectors.toList()));

            int totalCandies = 0;
            for(int i=0;i<len;i++){
                totalCandies += candies[i];
            }
            return totalCandies;

        }catch(Exception e){
            return -1;
        }
    }
}
