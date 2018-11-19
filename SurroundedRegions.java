// 130. Surrounded Regions

public class SurroundedRegions {

    public void run() {

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        System.out.println("Complete!");
    }

    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length ==0) return;

        int h = board.length, w = board[0].length;

        for(int i=0; i<board.length; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][w-1] == 'O') dfs(board, i, w-1);
        }
        for(int i=0; i<board[0].length; i++) {
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[h-1][i] == 'O') dfs(board, h-1, i);
        }

        for(int y=0; y<board.length; y++) {
            for(int x=0; x<board[0].length; x++) {
                if(board[y][x] == 'O') board[y][x] = 'X';
                else if(board[y][x] == '1') board[y][x] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int y, int x) {
        board[y][x] = '1';
        if(y-1>=0 && board[y-1][x] == 'O') dfs(board, y-1, x);
        if(y+1<board.length && board[y+1][x] == 'O') dfs(board, y+1, x);
        if(x-1>=0 && board[y][x-1] == 'O') dfs(board, y, x-1);
        if(x+1<board[0].length && board[y][x+1] == 'O') dfs(board, y, x+1);
    }

}
