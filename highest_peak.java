import java.util.LinkedList;
import java.util.Queue;

public class highest_peak {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] res = function1(matrix);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] function1(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    temp[i][j] = 0;
                }
            }
        }

        int[] dir = new int[]{-1,0,1,0};
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for(int d=0;d<dir.length;d++){
                    int newx = x + dir[d];
                    int newy = y + dir[(d + 1) % 4];
                    if(isvalid(newx,newy,m,n) && !visited[newx][newy]){
                        queue.offer(new int[]{newx,newy});
                        temp[newx][newy] = 1 + level;
                        visited[newx][newy] = true;
                    }
                }
            }

            level++;

        }

    
        return temp;
    }

    private static boolean isvalid(int newx, int newy, int m, int n){
        return newx >= 0 &&  newy >= 0 && newx < m && newy < n;
    }
}
