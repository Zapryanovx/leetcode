// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description

package dp;

public class LC_0714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int free = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, hold + prices[i] - fee);
        }

        return free;
    }
}
