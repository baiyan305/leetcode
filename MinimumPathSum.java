// 64. Minimum Path Sum

class MinimumPathSum {
	
	public static void main(String[] args){
		int[][] grid = {
			{1},
				{1}
		};
		
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for(int i=1; i<grid[0].length; i++){
			dp[i] = grid[0][i] + dp[i-1];
		}
		
		for(int row = 1; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(col == 0) {
					dp[col] += grid[row][col];
				} else {
					dp[col] = grid[row][col] + Math.min(dp[col], dp[col-1]);
				}
			}
		}
		
		return dp[grid[0].length-1];
    }
	
}