import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
        List<List<Integer>> temp = function1(array);
        System.out.println(temp);
    }

    public static List<List<Integer>> function1(int[] array){
        try{
            Arrays.sort(array);
            List<List<Integer>> temp = new ArrayList<>();

            int n = array.length;
            for(int first=0;first<n-2;first++){
                if(first > 0 && array[first] == array[first-1]){
                    continue;
                }
                int second = first + 1;
                int third = n - 1;
                while(second < third){
                    int sum = array[first] + array[second] + array[third];
                    if(sum == 0){
                        temp.add(Arrays.asList(array[first], array[second], array[third]));
                        while (second < third && array[second] == array[second + 1]) {
                            second++;
                        }
                        while(second < third && array[third] == array[third - 1]){
                            third--;
                        }
                        second++;
                        third--;
                    }else if(sum < 0){
                        second++;
                    }else{
                        third--;
                    }
                }
            }



            return temp;

        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
