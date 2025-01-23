import java.util.LinkedList;
import java.util.Queue;

public class numbers_of_islands {
    public static void main(String[] args) {
        String[][] grid = {
            {"1","1","1","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","0","0"}
        };

        System.out.println(function1(grid));

    }


    public static int function1(String[][] grid){

        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j].equals("1") && !visited[i][j]){
                    bfs(grid,visited,i,j,m,n);
                    islands++;
                }
            }
        }
        return islands; 
    }

    public static void bfs(String[][] grid, boolean[][] visited, int x, int y, int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int[] xdir = new int[]{-1,1,0,0};
        int[] ydir = new int[]{0,0,-1,1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currx = curr[0];
            int curry = curr[1];

            for(int d = 0;d < 4;d++){
                int newx = currx + xdir[d];
                int newy = curry + ydir[d];

                if(isValid(newx, newy, m, n) && grid[newx][newy] == "1" && !visited[newx][newy]){
                    visited[newx][newy] = true;
                    queue.offer(new int[]{newx,newy});
                }
            }
        }
    }
    public static boolean isValid(int newx, int newy, int m, int n){
        return newx >= 0 && newy >= 0 && newx < m && newy < n;
    }
}
