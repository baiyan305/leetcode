// 37. Sudoku Solver

public class SudokuSolver {

    public void run() {
    }

    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return;
        recursion(board, 0, 0);
    }

    private boolean recursion(char[][] board, int y, int x) {
        if(y == 9) return true;
        if(x == 9) return recursion(board, y+1, 0);

        if(board[y][x] == '.') {
            for(int i=1; i<10; i++) {
                board[y][x] = (char)('0'+i);
                if(isValid(board, y, x) && recursion(board, y, x+1)) return true;
            }
            board[y][x] = '.';
        } else {
            return recursion(board, y, x+1);
        }

        return false;
    }

    private boolean isValid(char[][] board, int y, int x) {
        char c = board[y][x];

        for(int i=0; i<9; i++) if(i!=x && board[y][i] == c) return false;
        for(int i=0; i<9; i++) if(i!=y && board[i][x] == c) return false;
        for(int i=y/3*3; i<y/3*3+3; i++)
            for(int j=x/3*3; j<x/3*3+3; j++)
                if((i!=y || j!=x) && board[i][j] == c) return false;

        return true;
    }

}
