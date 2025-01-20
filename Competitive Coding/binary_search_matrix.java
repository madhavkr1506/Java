public class binary_search_matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{12,20,30},{9,10,11},{21,22,23}};
        System.out.println(findelement(matrix, 11));

    }

    public static boolean findelement(int[][] mat, int x){
        for(int[] array : mat){
            boolean found = binarysearch(array, 0, array.length-1, x);
            if(found){
                return true;
            }
        }
        return false;


    }

    public static boolean binarysearch(int[] array, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return true;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }
}
