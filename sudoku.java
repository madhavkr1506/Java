public class sudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        solveSudoku(board);
        printBoard(board);

    }

    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void solveSudoku(char[][] board){
        backtracking(board);
    }

    public static boolean backtracking(char[][] board){

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(int k=1;k<=9;k++){
                        if(isValid(board, i, j, (char)(k + '0'))){
                            board[i][j] = (char) (k + '0');
                            if(backtracking(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }

        return true;

    }
    public static boolean isValid(char[][] board, int row, int col,char num){
        for(int i=0;i<board.length;i++){
            if(board[i][col] == num || board[row][i] == num){
                return false;
            }
            int rowbox = 3 * (row / 3) + i / 3;
            int colbox = 3 * (col / 3) + i % 3;
            if(board[rowbox][colbox] == num){
                return false;
            }
        }
        return true;

    }
}
