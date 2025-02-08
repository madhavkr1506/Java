import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class count_indegree {
    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid = new int[][]{{0,0,0,0},{1,0,0,0},{1,0,0,0},{0,1,1,0}};

        List<Integer> resultList = findInorder(grid);
        System.out.println(resultList);

    }


    public static List<Integer> findInorder(int[][] grid){
        int[] array = new int[grid.length];

        int rows = grid.length;
        int cols = grid[0].length;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col] == 1){
                    array[col]++;
                }
            }
        }

        List<Integer> inorderList = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.reverse(inorderList);
        return inorderList;
    }
}
