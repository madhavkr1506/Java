import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rat_maze {
    public static void main(String[] args) {
        int n = 4;
        String input = "1000110111000111";

        int[][] matrix = new int[n][n];

        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = input.charAt(k++) - '0';
            }
        }

        List<String> paths = new ArrayList<>();
        findPath(matrix,n,0,0,"",paths,new boolean[n][n]);

        Collections.sort(paths);

        for(String path : paths){
            System.out.print(path + " ");
        }
        
    }

    public static void findPath(int[][] matrix, int n, int row, int col, String path, List<String> paths, boolean[][] visited){
        if(row == n - 1 && col == n - 1){
            paths.add(path);
            return;
        }

        visited[row][col] = true;

        if(issafe(matrix,n,row+1,col,visited)){
            findPath(matrix, n, row+1, col, path + "D", paths, visited);
        }

        if(issafe(matrix,n,row,col+1,visited)){
            findPath(matrix, n, row, col+1, path + "R", paths, visited);
        }

        visited[row][col] = false;
    }

    public static boolean issafe(int[][] matrix, int n, int row, int col, boolean[][] visited){
        return row >= 0 && row < n && col >= 0 && col < n && matrix[row][col] == 1 && !visited[row][col]; 
    }
}
