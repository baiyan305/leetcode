// 276. Paint Fence

public class PaintFence {
	
	public static void main(String[] args) {
		System.out.println(numWays(3,3));
	}
	
	//dp[i] = (k-1)*dp[i-1] + dp[i-2];
	public static int numWays(int n, int k) {
		if(n==0 || k==0 || (n>2 && k==1)) return 0;
        
		int[] dp = {k, k*k, 0};
		if(n==1 || n==2) return dp[n-1];
		
		for(int i=2; i<n; i++) {
			dp[2] = (k-1) * (dp[1]+dp[0]);
			dp[0] = dp[1];
            dp[1] = dp[2];
		}
		
		return dp[2];
    }
	
}