// 174. Dungeon Game

class DungeonGame {
	
	public static void main(String[] args) {
	
		int[][] grid = {
			{-2,-30,3}
		};

		System.out.println(calculateMinimumHP(grid));
	}
	
	private static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

		int height = dungeon.length, width = dungeon[0].length;
		int[] dp = new int[width];
		dp[width-1] = dungeon[height-1][width-1] < 0 ? 1-dungeon[height-1][width-1] : 1;

		for(int row=height-1; row>=0; row--) {
			for(int col=width-1; col>=0; col--) {
				if(row == height-1 && col == width-1) continue;

				int min = 0;
				if(row == height-1) { // last row
					min = dungeon[row][col] - dp[col+1];
				}else if(col == width-1){ //last col
					min = dungeon[row][col] - dp[col];
				}else{
					min = dungeon[row][col] - Math.min(dp[col], dp[col+1]);
				}

				dp[col] = min >=0 ? 1 : 0 - min;
			}
		}

		return dp[0];
	}
	/*
	private static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

		int height = dungeon.length, width = dungeon[0].length;
		int[][] dp = new int[height][width];
		dp[height-1][width-1] = dungeon[height-1][width-1] < 0  ? 1 - dungeon[height-1][width-1] : 1;

		for(int row=height-1; row>=0; row--) {
			for(int col=width-1; col>=0; col--) {
				if(row == height-1 && col == width-1) continue;
				
				int min = 0;
				if(row == height-1) {
					min = dungeon[row][col] - dp[row][col+1];
				}else if(col == width-1){
					min = dungeon[row][col] - dp[row+1][col];
				}else{
					min = dungeon[row][col] - Math.min(dp[row+1][col], dp[row][col+1]);
				}

				dp[row][col] = min >=0 ? 1 : 0 - min;
			}
		} // end of for loop

		return dp[0][0];
    }
	*/
}