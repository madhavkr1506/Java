import java.util.PriorityQueue;

public class TrapRainWaterII {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        int maxWater = function1(array);
        System.out.println("Max trap: " + maxWater);


    }

    public static int function1(int[][] array){
        int rows = array.length;
        int cols = array[0].length;
        int totalCellsUnvisited = rows * cols;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        if(rows < 3 || cols < 3){
            return 0;
        }
        for(int i=0;i<rows;i++){
            pq.add(new int[]{array[i][0], i, 0});
            pq.add(new int[]{array[i][cols-1], i, cols-1});
            visited[i][0] = true;
            visited[i][cols-1] = true;
            totalCellsUnvisited--;
            totalCellsUnvisited--;
        }

        for(int i=1;i<cols-1;i++){
            pq.add(new int[]{array[0][i], 0, i});
            pq.add(new int[]{array[rows-1][i], rows-1, i});
            visited[0][i] = true;
            visited[rows-1][i] = true;
            totalCellsUnvisited--;
            totalCellsUnvisited--;
        }


        int maxWater = 0;
        int waterLevel = 0;
        while (!pq.isEmpty() && totalCellsUnvisited > 0) {
            int[] currCell = pq.poll();
            int height = currCell[0];
            int row = currCell[1];
            int col = currCell[2];
            waterLevel = Math.max(waterLevel, height);
            for(int i=0;i<4;i++){
                int newrow = row + dir[i][0];
                int newcol = col + dir[i][1];
                if (checkBoundary(rows, newrow, cols, newcol) && !visited[newrow][newcol]){
                    int neightbourheight = array[newrow][newcol];
                    if(neightbourheight < waterLevel){
                        maxWater += waterLevel - neightbourheight;
                    }
                    pq.offer(new int[]{neightbourheight, newrow, newcol});
                    visited[newrow][newcol] = true;
                    totalCellsUnvisited--;

                }
            }

        }
        return maxWater;
    }
    public static boolean checkBoundary(int rows, int newrow, int cols, int newcol){
        return newrow >= 0 && newrow < rows && newcol >=0 && newcol < cols;
    }
}
