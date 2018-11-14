// 51. N-Queens

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // 51. N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new int[n][n], 0, new int[n]);
        return res;
    }

    // int[] pos是用来记录皇后的位置
    // 如果pos[0] = 5, 含义是在第一行，皇后的位置是在第6列
    // 如果pos[1] = 1, 含义是在第二行，皇后的位置是在第2列
    private void backtracking(List<List<String>> res, int[][] board, int row, int[] pos) {
        if(row == board.length) {
            List<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for(int y=0; y<board.length; y++) {
                for(int x=0; x<board.length; x++)
                    builder.append(board[y][x] == 0 ? '.' : 'Q');
                list.add(builder.toString());
                builder.setLength(0);
            }

            res.add(list);
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

    // Check if the queen we insert is valid
    // 这个题目的关键，就是如果判断新加入的皇后位置，是否合法
    // 正常来讲，是需要判断同一行，同一列，对角线4个方向上是否已经存在皇后了
    // 但是同一行是不用判断的，因为我们插入皇后的时候，每一行只插入一个，所有同一行不会重复
    // 同一列和对角线是需要判断的
    // 我们用一个数组记录之前没一行中皇后的位置
    // 对比当前行皇后的位置和之前所有行皇后的位置，看是否在同一列
    // 对角线的话，如果两个皇后在同一个对角线上，那么Math.abs(pos[i] - pos[row]) == Math.abs(i-row)
    private boolean isValid(int[][] board, int[] pos, int row) {
        for(int i=0; i<row; i++) {
            if(pos[i] == pos[row] || Math.abs(pos[i] - pos[row]) == Math.abs(i-row)) return false;
        }

        return true;
    }

}
