public class grid_basic2 {
    public static void main(String[] args) {
        // int[][] grid = new int[3][3];

        // here I am printing an empty grid (2D matrix)

        // System.out.println("1.");
        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        // System.out.println("2.");


        // this is my second grid which is filled with 1 at some place


        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[i].length;j++){
        //         if((i == 0) || (j == grid[i].length - 1)){
        //             grid[i][j] = 1;
        //         }
        //     }
        // }        

        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        // System.out.println("3.");

        // now this is my third grid and i am filling some position with 1

        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[i].length;j++){
        //         if(i == 0 || j == 0){
        //             grid[i][j] = 1;
        //         }
        //     }
        // }

        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }



        // System.out.println("4.");

        // here i am printing grid structure with different position labled in it.

        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[i].length;j++){
        //         if((i == grid.length - 1) || j == 0){
        //             grid[i][j] = 1;
        //         }
        //     }
        // }


        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        // System.out.println("5.");
        // now i fill diagonal element of grid structure

        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[i].length;j++){
        //         if(i == j){
        //             grid[i][j] = 1;
        //         }
        //     }
        // }



        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        int n = 4;
        int m = 4;

        int ways = count_bear_mmove(n, m);
        System.out.println("Bear can reach to the bottom right corner in " + ways + " ways.");


    }


    // there is a question that : A bear starts at the top-left corner of an N x M grid (matrix) and wants to reach the bottom-right corner. The bear can only move either right or down (i.e., cannot move left or up). How many distinct ways can the bear move from the top-left corner to the bottom-right corner? Additionally, implement a function to calculate this number of ways.


    public static int count_bear_mmove(int n, int m){

        int[][] grid = new int[n][m];

        for(int i=0;i<n;i++){
            grid[i][0] = 1;
        }

        for(int j=0;j<m;j++){
            grid[0][j] = 1;
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[n-1][m-1];
        
    }
}
