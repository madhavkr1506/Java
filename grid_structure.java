import java.util.HashMap;
import java.util.HashSet;

public class grid_structure {

    public static void printGrid(int[][] grid){
        int len = grid.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,1,1},{1,0,1}};
        printGrid(grid);

        System.out.println("Hey...........");

        System.out.println(findLargeIsland(grid));

        printGrid(grid);

    }

    public static int findLargeIsland(int[][] grid){
        int len = grid.length;
        HashMap<Integer, Integer> map = gridTraversal(grid);
        int maxIsland = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    int[] xdir = {-1,0,1,0};
                    int[] ydir = {0,-1,0,1};
                    for(int d=0;d<4;d++){
                        int newx = i + xdir[d];
                        int newy = j + ydir[d];
                        if(isvalid(newx, newy, len) && grid[newx][newy] > 1){
                            set.add(grid[newx][newy]);
                        }
                    }

                    int currentSize = 1;
                    for(int islandID : set){
                        currentSize += map.get(islandID);

                    }
                    maxIsland = Math.max(maxIsland, currentSize);
                }
            }
        }

        if(maxIsland == 0){
            for(int size : map.values()){
                maxIsland = Math.max(maxIsland, size);
            }
        }
        return maxIsland;

    }

    public static HashMap<Integer,Integer> gridTraversal(int[][] grid){
        int len = grid.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int island = 2;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(grid[i][j] == 1){
                    int size[] = new int[1];
                    size[0] = fillPosition(grid, i, j, island, size);
                    map.put(island, size[0]);
                    island++;
                }
            }
        }

        return map;
    }

    public static int fillPosition(int[][] grid, int row, int col, int island, int[] size){
        int len = grid.length;
        int[] xdir = {-1,0,1,0};
        int[] ydir = {0,-1,0,1};
        grid[row][col] = island;
        size[0]++;
        for(int d=0;d<4;d++){
            int newrow = row + xdir[d];
            int newcol = col + ydir[d];

            if(isvalid(newrow, newcol, len) && grid[newrow][newcol] == 1){
                fillPosition(grid, newrow, newcol, island, size);
            }
        }
        return size[0];
    }

    public static boolean isvalid(int newx, int newy, int len){
        return newx >= 0 && newx < len && newy >= 0 && newy < len;
    }
}
