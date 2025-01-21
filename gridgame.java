public class gridgame {
    public static void main(String[] args) {
        int[][] grid = {{2,5,4},{1,5,1}};
        System.out.println(function1(grid));
    }

    public static int function1(int[][] grid){
        int col = grid[0].length;
        long topsum = 0;
        for(int i=0;i<col;i++){
            topsum += grid[0][i];
        }

        long bottomsum = 0;
        long ans = Long.MAX_VALUE;

        for(int i=0;i<col;i++){
            topsum -= grid[0][i];
            ans = Math.min(ans, Math.max(topsum, bottomsum));
            bottomsum += grid[1][i];
        }

        return (int)ans;
    }
}
