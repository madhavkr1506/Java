import java.util.LinkedList;
import java.util.Queue;

public class max_fishes {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        int row = grid.length;
        int col = grid[0].length;

        int requiredMax = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] != 0){
                    requiredMax = Math.max(requiredMax, function2(i, j, grid));
                }
            }
        }

        System.out.println(requiredMax);
    }

    public static int function1(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        int ans = grid[row][col];
        grid[row][col] = 0;
        ans += function1(row + 1, col, grid) + function1(row - 1, col, grid) + function1(row, col + 1, grid) + function1(row, col - 1, grid);

        return ans;
    }

    public static int function2(int row, int col, int[][] grid){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});

        int ans = 0;

        int[] xdir = {-1,0,1,0};
        int[] ydir = {0,-1,0,1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            ans += grid[x][y];

            grid[x][y] = 0;

            for(int i=0;i<4;i++){
                int newx = x + xdir[i];
                int newy = y + ydir[i];

                if(newx < 0 || newy < 0 || newx >= grid.length || newy >= grid[0].length){
                    continue;
                }

                if(grid[newx][newy] != 0){
                    queue.add(new int[]{newx,newy});
                }
            }

        }

        return ans;
        
    }

    
}