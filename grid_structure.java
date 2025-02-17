public class grid_structure {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,1,1},{1,0,1}};
        printGrid(grid);

        System.out.println("Hey...........");

        System.out.println(gridTraversal(grid));

        printGrid(grid);

    }

    public static void printGrid(int[][] grid){
        int len = grid.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridTraversal(int[][] grid){
        int len = grid.length;

        int island = 2;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(grid[i][j] == 1){
                    fillPosition(grid, i, j, island);
                    island++;
                }
            }
        }


        int largeIsland = maxIslandFunction(grid);
        return largeIsland;

    }

    public static void fillPosition(int[][] grid, int row, int col, int island){
        int len = grid.length;
        int[] xdir = {-1,0,1,0};
        int[] ydir = {0,-1,0,1};
        grid[row][col] = island;
        for(int d=0;d<4;d++){
            int newrow = row + xdir[d];
            int newcol = col + ydir[d];

            if(isvalid(newrow, newcol, len) && grid[newrow][newcol] == 1){
                fillPosition(grid, newrow, newcol, island);
            }
        }
    }

    public static int maxIslandFunction(int[][] grid){
        int maxCount = 0;
        int len = grid.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(grid[i][j] == 0){
                    int count[] = new int[1];
                    countPosition(grid, i, j,count);
                    maxCount = Math.max(maxCount, count[0]);
                }
            }
        }
        return maxCount;
    }

    public static void countPosition(int[][] grid, int row, int col, int[] count){
        int len = grid.length;
        int[] xdir = {-1,0,1,0};
        int[] ydir = {0,-1,0,1};
    
        grid[row][col] = 1;
        count[0]++;
        for(int d=0;d<4;d++){
            int newrow = row + xdir[d];
            int newcol = col + ydir[d];

            if(isvalid(newrow, newcol, len) && grid[newrow][newcol] == 1){
                countPosition(grid, newrow, newcol, count);
            }
        }
        grid[row][col] = 0;
    }


    public static boolean isvalid(int newx, int newy, int len){
        return newx >= 0 && newx < len && newy >= 0 && newy < len;
    }
}
