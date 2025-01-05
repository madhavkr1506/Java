public class assign_zero_matrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1,1,1},{1,0,1},{-1,1,1}};
        assignZero(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void assignZero(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstrowzero = false;
        for(int i=0;i<m;i++){
            if(matrix[0][i] == 0){
                firstrowzero = true;
                break;
            }
        }
        boolean firstcolzero = false;
        for(int i=0;i<n;i++){
            if(matrix[i][0] == 0){
                firstcolzero = true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstcolzero){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstrowzero){
            for(int i=0;i<m;i++){
                matrix[0][i] = 0;
            }
        }
    }
}