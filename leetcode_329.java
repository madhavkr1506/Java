public class leetcode_329 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};

        System.out.println("Longest Increasing Path in a Matrix: " + longestIncreasingPath(matrix));

    }


    public static int longestIncreasingPath(int[][] matrix){

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        int max_path = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max_path = Math.max(max_path, dfs(matrix, memo, i, j));
            }
        }
        return max_path;

    }

    public static int dfs(int[][] matrix, int[][] memo, int row, int col){

        if(memo[row][col] != 0){
            return memo[row][col];
        }

        int[] x_dir = {-1, 1, 0, 0};
        int[] y_dir = {0, 0, 1, -1};

        int max_length = 1;
        
        for(int i=0;i<4;i++){
            int new_x = row + x_dir[i];
            int new_y = col + y_dir[i];

            if(new_x >=0 && new_x < matrix.length && new_y >=0 && new_y < matrix[0].length){
                if(matrix[new_x][new_y] > matrix[row][col]){
                    int path_length = 1 + dfs(matrix, memo, new_x, new_y);
                    max_length = Math.max(max_length, path_length);
                }
            }

        }
        memo[row][col] = max_length;
        return max_length;

    }

}
