import java.util.Scanner;

public class KnightTourProblem {
    public static void chessBoard(int[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean knighttour(int[][] board, int row, int col, int move){
        int size = board.length;
        
        
        if (move == size * size) {
            board[row][col] = move;
            chessBoard(board);
            board[row][col] = 0;
            return true;
        }

        
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};
        
        for (int i = 0; i < 8; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];
            
            if (nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size && board[nextRow][nextCol] == 0) {
                board[row][col] = move;
                if (knighttour(board, nextRow, nextCol, move + 1)) {
                    return true;
                }
                board[row][col] = 0;  
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size: ");
        int size = sc.nextInt();
        System.out.print("Enter starting row: ");
        int row = sc.nextInt();
        System.out.print("Enter starting column: ");
        int col = sc.nextInt();
        
        int[][] board = new int[size][size];
        if (!knighttour(board, row, col, 1)) {
            System.out.println("No solution found");
        }
        
        sc.close();
    }
}
