// 361. Bomb Enemy

public class BombEnemy {

    public static void main(String[] args) {
        char[][] grid = {
            {'0','E','0','0'},
            {'E','0','W','E'},
            {'0','E','0','0'}
        };

        System.out.println(maxKilledEnemies(grid));
    }

	public static int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int height = grid.length, width = grid[0].length, max = 0, rowCount = 0;
		int[] colCount = new int[width];
		
		for(int h=0; h<height; h++) {
			for(int w=0; w<width; w++) {
				if(grid[h][w] == 'W') continue;
				if(w==0 || grid[h][w-1] == 'W') rowCount = scanRow(grid, h, w);
				if(h==0 || grid[h-1][w] == 'W') colCount[w] = scanCol(grid, h, w);
				
				if(grid[h][w] == '0') max = Math.max(max, rowCount+colCount[w]);
			}
		}
		
		return max;
	}
	
	private static int scanRow(char[][] grid, int row, int col) {
		int enemy = 0;
		
		while(col < grid[0].length && grid[row][col] != 'W') {
			if(grid[row][col] == 'E')enemy++;
			col++;
		}
		
		return enemy;
	}
	
	private static int scanCol(char[][] grid, int row, int col) {
		int enemy = 0;
		
		while(row < grid.length && grid[row][col] != 'W') {
			if(grid[row][col] == 'E')enemy++;
			row++;
		}
		
		return enemy;
	}
	
	/*
    public static int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int height = grid.length, width = grid[0].length;
        int[][] left = new int[height][width];
        int[][] right = new int[height][width];
        int[][] above = new int[height][width];
        int[][] below = new int[height][width];

        for(int h=0; h<height; h++) {
            int sum = 0;
            for(int w=0; w<width; w++) {
                char c = grid[h][w];
                if(c == 'W') sum = 0;
                else if(c == 'E') sum++;
                left[h][w] = sum;        
            }
        }

        for(int h=0; h<height; h++) {
            int sum = 0;
            for(int w=width-1; w>=0; w--) {
                char c = grid[h][w];
                if(c == 'W') sum = 0;
                else if(c == 'E') sum++;
                right[h][w] = sum;        
            }
        }

        for(int w=0; w<width; w++) {
            int sum = 0;
            for(int h=0; h<height; h++) {
                char c = grid[h][w];
                if(c == 'W') sum = 0;
                else if(c == 'E') sum++;
                above[h][w] = sum;        
            }
        }

        for(int w=0; w<width; w++) {
            int sum = 0;
            for(int h=height-1; h>=0; h--) {
                char c = grid[h][w];
                if(c == 'W') sum = 0;
                else if(c == 'E') sum++;
                below[h][w] = sum;        
            }
        }

        int max = 0;
        for(int h=0; h<height; h++) {
            for(int w=0; w<width; w++) {
                if(grid[h][w] == '0'){
                    max = Math.max(max, left[h][w]+right[h][w]+above[h][w]+below[h][w]);
                }     
            }
        }

        return max;
    }
	*/
}
