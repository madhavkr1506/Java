public class n_queen {

     public static void main(String[] args) {
        int[][] grid = new int[4][4];

        solveNQueen(grid);

        // printGrid(grid);

     }

     public static void printGrid(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
     }

     public static void solveNQueen(int[][] grid){
        backtracking(grid,0);
     }

     public static boolean backtracking(int[][] grid, int row){

        if(row >= grid.length){
            printGrid(grid);
            System.out.println();
            return false;
        }

        for(int col = 0;col < grid.length;col++){
            if(isValid(grid, row, col)){
                grid[row][col] = 1;
                if(backtracking(grid, row+1)){
                    return true;
                }
                grid[row][col] = 0;
            }

        }
        return false;

     }

     public static boolean isValid(int[][] grid, int row, int col){

        for(int i=0;i<row;i++){
            if(grid[i][col] == 1){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(grid[i][j] == 1){
                return false;
            }
        }

        for(int i=row,j=col;i<grid.length && j>=0;i++,j--){
            if(grid[i][j] == 1){
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < grid.length; i--, j++) {
            if (grid[i][j] == 1) return false;
        }

        
        for (int i = row, j = col; i < grid.length && j < grid.length; i++, j++) {
            if (grid[i][j] == 1) return false;
        }

        return true;
     }
}