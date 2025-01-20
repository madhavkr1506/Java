import java.util.HashMap;

public class first_completely_painted_row_or_column {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,2,5},{1,4,6},{8,7,9}};
        int[] array = new int[]{2,8,7,4,1,3,5,6,9};

        System.out.println("Index: " + function1(matrix, array));
    }
    public static int function1(int[][] matrix,int[] array){
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                map.put(matrix[i][j], new int[]{i,j});
            }
        }
    
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int row = map.get(array[i])[0];
                int col = map.get(array[i])[1];
                visited[row][col] = true;
                if(function2(visited, row, col)){
                    return i;
                }
            }
        }
        return -1;
    
    
    }

    public static boolean function2(boolean[][] visited, int row, int col){
        boolean isrowpainted = true;
        for(int i=0;i<visited[row].length;i++){
            if(!visited[row][i]){
                isrowpainted = false;
                break;
            }
        }

        boolean iscolumnpainted = true;
        for(int i=0;i<visited.length;i++){
            if(!visited[i][col]){
                iscolumnpainted = false;
                break;
            }
        }

        return isrowpainted || iscolumnpainted;
    }
}

