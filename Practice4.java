import java.util.Arrays;

public class Practice4 {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;
        System.out.println(function1(candies, k));
    }

    // time complexity : n x max(candies)

    // public static int function1(int[] candies, int k){
    //     int max_candy = 0;

    //     int max_candy_box = Arrays.stream(candies).max().getAsInt();
    //     for(int i=1;i<=max_candy_box;i++){
    //         int count = 0;
    //         for(int j=0;j<candies.length;j++){
    //             count += candies[j] / i;
    //         }
    //         if(count >= k){
    //             max_candy = i;
    //         }
    //     }

    //     return max_candy;
    // }


    // time complexity : n x log(max(candies))

    public static int function1(int[] candies, int k){
        if(k == 0){
            return 0;
        }
        int max_candy = 0;
        int low = 0;
        int high = Arrays.stream(candies).max().getAsInt();
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            long count = 0;
            for(int candy : candies){
                count += candy / mid;
            }
            if(count >= k){
                max_candy = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return max_candy;
    }
}
