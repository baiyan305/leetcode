// 52. N-Queens II

public class NQueensII {

    public int totalNQueens(int n) {
        int[] res = new int[1];
        backtracking(res, new int[n][n], 0, new int[n]);
        return res[0];
    }

    private void backtracking(int[] res, int[][] board, int row, int[] pos) {
        if(row == board.length) {
            res[0]++;
            return;
        }

        for(int i=0; i<board.length; i++) {
            pos[row] = i;
            board[row][i] = 1;
            if(isValid(board, pos, row))
                backtracking(res, board, row+1, pos);
            board[row][i] = 0;
        }
    }

    private boolean isValid(int[][] board, int[] pos, int row) {
        for(int i=0; i<row; i++) {
            if(pos[i] == pos[row] || Math.abs(pos[i] - pos[row]) == Math.abs(i-row)) return false;
        }

        return true;
    }

}
