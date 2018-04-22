// 343. Integer Break

public class IntegerBreak {
	
	public static void main(String[] args) {
		System.out.println(integerBreak(1));
	}
	
	public static int integerBreak(int n) {
		if(n == 0) return 0;
        int[] dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=i-1; j>= i/2; j--) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
			}
		}

		return dp[n];
    }
	
}