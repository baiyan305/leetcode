// 322. Coin Change

public class CoinChange {
	
	public static void main(String[] args) {
		int[] coins = new int[]{1,2,5};
		System.out.println(coinChange(coins, 11));
	}
	
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		
		for(int i=1; i<=amount; i++) {
			int min = Integer.MAX_VALUE;
			boolean combine = false;
			for(int coin : coins) {
				if(i-coin>=0 && dp[i - coin] != -1) {
					min = Math.min(min, dp[i - coin]+1);
					combine = true;
				}
			}
			dp[i] = combine ? min : -1;
		}
		
		return dp[amount];
    }
	
}