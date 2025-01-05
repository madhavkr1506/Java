import java.util.ArrayList;

public class print_subarray_using_backtracking {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        printSubArray(array, 0, new ArrayList<>());
    }
    public static void printSubArray(int[] array, int index, ArrayList<Integer> list){
        if(index == array.length){
            System.out.println(list);
            return;
        }

        list.add(array[index]);
        printSubArray(array, index + 1, list);

        list.remove(list.size() - 1);
        printSubArray(array, index + 1, list);
        
    }
}
