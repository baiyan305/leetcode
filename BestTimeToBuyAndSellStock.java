// 121. Best Time to Buy and Sell Stock

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int profit = maxProfit(new int[]{1,2,3,4,5,4,3,2,1,2,3,4,});
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;

        for(int i=1; i< prices.length; i++) {
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

}