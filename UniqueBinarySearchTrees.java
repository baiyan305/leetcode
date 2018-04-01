// 96. Unique Binary Search Trees

class UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	
	public static int numTrees(int n) {
        int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int total=2; total<=n; total++) {
			for(int left = 0; left<=total-1; left++) {
				dp[total] += dp[left] * dp[total-left-1];
			}
		}
		
		return dp[n];
    }
	
}