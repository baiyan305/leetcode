// 375. Guess Number Higher or Lower II

public class GuessNumberHigherOrLowerII {
	
	public static void main(String[] args) {
		System.out.println(getMoneyAmount(10));
	}
	
	public static int getMoneyAmount(int n) {
		int[][] dp = new int[n+1][n+1];
        for(int right = 2; right <= n; right++) {
			for(int left = right-1; left >= 1; left--) {
				int cost = Integer.MAX_VALUE;
				for(int i=left+1; i<right; i++) {
					int tmp = i + Math.max(dp[left][i-1], dp[i+1][right]);
					cost = Math.min(cost, tmp);
				}
				dp[left][right] = right - left == 1 ? left : cost;
			}
		}
		
		return dp[1][n];
    }
	
}