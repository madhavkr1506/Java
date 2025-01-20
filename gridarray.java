public class gridarray {

    public static void main(String[] args) {
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        int[][] matrix = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};

        boolean found = false;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                int currentrow = i;
                int currentcol = j;
                for(int direction=0;direction<dir.length;direction++){
                    int neighbourx = currentrow + dir[direction][0];
                    int neighboury = currentcol + dir[direction][1];
                    if(isvalid(neighbourx, neighboury, matrix.length,matrix[i].length)){
                        if(matrix[i][j] != matrix[neighbourx][neighboury]){
                            found = true;
                            break;
                        }
        
                    }
                }
                
            }
        }

        if(found){
            System.out.println("Mismatch element");
        }
        else{
            System.out.println("No mismatch element");
        }

        
    }


    private static boolean isvalid(int row, int col, int rowslength, int colslength){
        return row >= 0 && col >= 0 && row < rowslength && col < colslength; 
    }
}