import java.util.Scanner;

public class NQueen1 {
    public static void printboard(int[][] board){
        int N = board.length;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkQueenCanBePlaced(int[][] board, int row, int col){
        int N = board.length;
        for(int i=0;i<col;i++){
            if(board[row][i] == 1){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
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

    public static boolean placeNQueen(int[][] board, int col){
        int N = board.length;
        if(col>=N){
            return true;
        }
        for(int i=0;i<N;i++){
            if(checkQueenCanBePlaced(board, i, col)){
                board[i][col] = 1;
                if(placeNQueen(board, col+1)){
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static boolean solveNQueen(int N){
        int[][] board = new int[N][N];
        if(!placeNQueen(board, 0)){
            System.out.println("Solution doesn't exits");
            return false;
        }
        printboard(board);
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 4;
        solveNQueen(N);
        sc.close();
    }
}
