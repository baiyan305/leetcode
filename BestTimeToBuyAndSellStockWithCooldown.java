// 309. Best Time to Buy and Sell Stock with Cooldown

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int unhold = 0, hold = -prices[0], sold = 0;

        for(int i=1; i<prices.length; i++) {
            int unholdbackup = unhold, holdbackup = hold;
            unhold = Math.max(unhold, sold);
            hold = Math.max(hold, unholdbackup-prices[i]);
            sold = holdbackup+prices[i];
        }

        return Math.max(unhold, sold);
    }
    /*
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int len = prices.length;
        int[] hold = new int[len], unhold = new int[len], sold = new int[len];
        hold[0] = -prices[0];
        for(int i=1; i<len; i++) {
            unhold[i] = Math.max(unhold[i-1], sold[i-1]);
            hold[i] = Math.max(hold[i-1], unhold[i-1]-prices[i]);
            sold[i] = hold[i-1] + prices[i];
        }

        return Math.max(unhold[len-1], sold[len-1]);
    }
    */
}
