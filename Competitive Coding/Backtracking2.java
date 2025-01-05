public class Backtracking2 {
    public static void displayboard(int[][] board){
        int N = board.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean checkQueenCanBePlaced(int[][] board,int row,int col){
        int N = board.length;
        for(int i=0;i<col;i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        for(int i=row,j=col; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        for(int i=row,j=col;i<N && j>=0;i++,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static boolean placedQueen(int[][] board,int col){
        int N = board.length;
        if(col >= N){
            return true;
        }

        for(int i=0;i<N;i++){
            if(checkQueenCanBePlaced(board, i, col)){
                board[i][col] = 1;
                if(placedQueen(board,col+1)){
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        if(!placedQueen(board, 0)){
            System.out.println("Not a possible answer");
        }else{
            displayboard(board);
        }
        
    }
}
