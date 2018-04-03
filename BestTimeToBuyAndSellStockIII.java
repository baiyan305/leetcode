// 123. Best Time to Buy and Sell Stock III

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{4,4,6,1,1,4,2,5}));
	}
	
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
		
		//scan from left to right
		int[] left = new int[prices.length];
		int min = prices[0];
		for(int i=1; i<prices.length; i++) {
			left[i] = Math.max(left[i-1], prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		
		//scan from right to left
		int[] right = new int[prices.length];
		int max = prices[prices.length-1];
		for(int i=prices.length-2; i>=0; i--) {
			right[i] = Math.min(right[i+1], prices[i]-max);
			max = Math.max(max, prices[i]);
		}
		
		int res = 0;
		for(int i=0; i<prices.length; i++) {
			res = Math.max(res, left[i]-right[i]);
		}
		
		return res;
    }
	
}