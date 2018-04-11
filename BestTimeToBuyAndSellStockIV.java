// 188. Best Time to Buy and Sell Stock IV

public class BestTimeToBuyAndSellStockIV {
	
	public static void main(String[] args) { 
		System.out.println(maxProfit(3, new int[]{2,5,7,1,4,3,1,3}));
	}
	
	public static int maxProfit(int k, int[] prices) {
		if(k>=(prices.length/2)) {
			int profit = 0;
			for(int i=1; i<prices.length; i++) {
				if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
			}
			
			return profit;
		}
		
		int[][] global = new int[k+1][prices.length];
		//int[][] local = new int[k+1][prices.length]; 
		for(int count=1; count<=k; count++) { // number of transaction
			int local = Integer.MIN_VALUE;
			for(int day=1; day<prices.length; day++) { // price of day
				local = Math.max(local, global[count-1][day-1]-prices[day-1]);
				global[count][day] = Math.max(global[count][day-1], prices[day]+local);
			}
		} 
		
		return global[k][prices.length-1];
    }
	
}