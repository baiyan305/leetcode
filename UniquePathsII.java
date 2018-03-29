// 63. Unique Paths II

class UniquePathsII {
	
	public static void main(String[] args) {
		int[][] grid = {
			{0,0}
		};
		
		System.out.println(uniquePathsWithObstacles(grid));
	}
	
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
		int height =  obstacleGrid.length, width = obstacleGrid[0].length;
		
        int[] dp = new int[obstacleGrid[0].length];
		dp[0] = 1;
		
		for(int[] row : obstacleGrid) {
			for(int i=0; i<width; i++) {
				if(row[i] == 1){
					dp[i] = 0;
				}else if(i>0){
					dp[i] += dp[i-1];
				}
			}
		}
		
		return dp[width-1];
    }
	
}