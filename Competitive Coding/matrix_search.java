public class matrix_search {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10,20,30},{11,21,31},{12,22,33}};
        int[] store_position = findelement(matrix, 33);
        for(int i : store_position){
            System.out.print(i + " ");
        }

    }
    public static int[] findelement(int[][] matrix, int target){
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return new int[]{row, column};
            }else if (target < matrix[row][column]){
                column -= 1;
            }else{
                row += 1;
            }
        }
        return new int[]{};


    }
}
