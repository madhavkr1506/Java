public class GridBasic {
    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        // System.out.println("I am printing elements in horizontal way");
        // System.out.println("For each loop");
        // for(int[] i : grid){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();

        // }

        // System.out.println("For loop");

        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[i].length;j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("While loop");

        // int row = 0;
        // int col = 0;

        // while (row != grid.length) {
        //     while (col != grid[row].length) {
        //         System.out.print(grid[row][col++] + " ");
                
        //     }
        //     col=0;
        //     row++;
        //     System.out.println();
            
            
        // }

        // System.out.println("Now I have to print elements in vertical way");

        // System.out.println("While loop");

        // int row = 0;
        // int col = 0;

        // while (col != grid[row].length ) {
        //     while (row != grid.length) {
        //         System.out.print(grid[row++][col] + " ");
        //     }
        //     row = 0;
        //     col++;
        //     System.out.println();
        // }

        // System.out.println("Now we will print transpose of a grid : ");

        // for(int i=0;i<grid.length;i++){
        //     for(int j=i+1;j<grid[i].length;j++){
        //         int temp = grid[i][j];
        //         grid[i][j] = grid[j][i];
        //         grid[j][i] = temp;
        //     }


        // }

        // System.out.println("I want to rotate grid by 90° in clock wise direction ");
        // for(int i=0;i<grid.length;i++){
        //     int left = 0;
        //     int right = grid.length - 1;
        //     while (left < right) {
        //         int temp = grid[i][left];
        //         grid[i][left] = grid[i][right];
        //         grid[i][right] = temp; 
        //         left++;
        //         right--;
        //     }
        // }

        // System.out.println("Now i have to rotate it by 90° counter clock wise direction");

        // for(int i=0;i<grid.length;i++){
        //     int up = 0;
        //     int down = grid.length - 1;

        //     while (up < down) {
        //         int temp = grid[up][i];
        //         grid[up][i] = grid[down][i];
        //         grid[down][i] = temp;
        //         up++;
        //         down--;
        //     }
        // }

        System.out.println("I want to rotate it by 180° in clock wise direction");

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length / 2;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[i][grid.length - j - 1];
                grid[i][grid.length - j - 1] = temp;
            }
        }

        for(int i=0;i<grid.length;i++){
            int up = 0;
            int down = grid.length - 1;
            while (up < down) {
                int temp = grid[up][i];
                grid[up][i] = grid[down][i];
                grid[down][i] = temp;
                up++;down--;
            }
        }



        for(int[] i : grid){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }


        

        
    }
}
