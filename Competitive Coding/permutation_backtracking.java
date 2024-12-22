public class permutation_backtracking {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        permutate(array, 0);

    }

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void permutate(int[] array, int index){
        if(index == array.length){
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=index;i<array.length;i++){
            swap(array,index, i);
            permutate(array, index + 1);
            swap(array,index, i);
        }
    }
}
