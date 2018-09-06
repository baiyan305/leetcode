// 36. Valid Sudoku

public class ValidSudoku {
	
	public void run() {

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                char c = board[y][x];
                if(c != '.')
                    if( !set.add(c+" in row "+y) || !set.add(c+" in col "+x) || !set.add(c+" in block "+(x/3+y/3*3)) ) return false;
            }
        }
        return true;
    }
	
}