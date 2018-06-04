// 79. Word Search

public class WordSearch {
	
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		
		System.out.println(exist(board, "ABCB"));
	}
	
	public static boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
		
		for(int y=0; y<board.length; y++) {
			for(int x=0; x<board[0].length; x++) {
				if(backtracking(used, board, x, y, word, 0))
					return true;
			}
		}
		
		return false;
    }
	
	private static boolean backtracking(boolean[][] used, char[][] board, int x, int y, String word, int index) {
		if(index == word.length()) return true;
		if(x<0 || x>=board[0].length || y<0 || y>=board.length) return false;
		if(used[y][x] || board[y][x] != word.charAt(index)) return false;
		
		used[y][x] = true;
		if(backtracking(used, board, x+1, y, word, index+1)||
		   backtracking(used, board, x-1, y, word, index+1)||
		   backtracking(used, board, x, y+1, word, index+1)||
		   backtracking(used, board, x, y-1, word, index+1)) 
		   return true;
		used[y][x] = false;
		
		return false;
	}
	
}