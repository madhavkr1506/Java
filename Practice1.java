import java.util.ArrayList;

public class Practice1 {
    public static void main(String[] args) {
        int num = 4;
        int[][] grid = new int[num][num];
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        PlaceQueen(grid, 0, temp, list);

        System.out.println(list);
    }

    public static boolean PlaceQueen(int[][] grid, int row, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list){
        if(row >= grid.length){
            list.add(new ArrayList<>(temp));
            return true;
        }


        for(int i=0;i<grid.length;i++){
            if(CanPlace(grid, row, i)){
                grid[row][i] = 1;
                temp.add(i);
                PlaceQueen(grid, row+1, temp, list);
                grid[row][i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
        return false;
    }

    public static boolean CanPlace(int[][] grid, int row, int col){
        int n = grid.length;
        for(int i=0;i<n;i++){
            if(grid[i][col] == 1){
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(grid[i][j] == 1){
                return false;
            }
        }

        for(int i=row, j=col; i<n && j>=0; i++, j--){
            if(grid[i][j] == 1){
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
