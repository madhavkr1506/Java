import java.util.ArrayList;

public class GenerateSubsequence {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        function1(array);
    }

    public static void function1(int[] array){
        try{
            for(int i=0;i<(1<<array.length);i++){
                ArrayList<Integer> list = new ArrayList<>();
                for(int j=0;j<array.length;j++){
                    if ((i & (1 << j)) != 0){
                        list.add(array[j]);
                    }
                }
                System.out.println(list);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
