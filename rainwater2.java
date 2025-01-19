import java.util.PriorityQueue;

public class rainwater2 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
            {1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}
        };

        System.out.println("Max Water: " + function(array));
    }

    public static int function(int[][] array){
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int rowslength = array.length;
        int colslength = array[0].length;
        if(rowslength < 3 || colslength < 3){
            return 0;
        }
        int maxwater = 0;
        int waterlevel = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        int unvisitedcells = rowslength * colslength;
        boolean[][] visited = new boolean[rowslength][colslength];

        for(int i=0;i<rowslength;i++){
            pq.offer(new int[]{array[i][0],i,0});
            pq.offer(new int[]{array[i][colslength-1],i,colslength-1});
            visited[i][0] = true;
            visited[i][colslength - 1] = true;
            unvisitedcells--;
            unvisitedcells--;
        }

        for(int i=1;i<colslength-1;i++){
            pq.offer(new int[]{array[0][i],0,i});
            pq.offer(new int[]{array[rowslength-1][i],rowslength - 1,i});
            visited[0][i] = true;
            visited[rowslength-1][i] = true;
            unvisitedcells--;
            unvisitedcells--;
        }

        while (!pq.isEmpty() && unvisitedcells > 0) {
            int[] currentcell = pq.poll();
            int height = currentcell[0];
            int row = currentcell[1];
            int col = currentcell[2];
            waterlevel = Math.max(waterlevel, height);

            for(int i=0;i<dir.length;i++){
                int neighbourrow = row + dir[i][0];
                int neighbourcol = col + dir[i][1];

                if(function2(neighbourrow, neighbourcol, rowslength, colslength) && !visited[neighbourrow][neighbourcol]){
                    int neighbourheight = array[neighbourrow][neighbourcol];
                    if(neighbourheight < waterlevel){
                        maxwater += waterlevel - neighbourheight;
                    }
                    pq.offer(new int[]{neighbourheight,neighbourrow, neighbourcol});
                    visited[neighbourrow][neighbourcol] = true;
                    unvisitedcells--;
                }

            }
            
        }
        return maxwater;
    }
    private static boolean function2(int row,int col, int rowlength, int collength){
        return row >= 0 && col >= 0 && row < rowlength && col < collength;
    }
}
