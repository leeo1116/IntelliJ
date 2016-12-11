package algorithms.leetcode._188_best_time_to_buy_and_sell_stock_IV;

/**
 * Created by Charlie on 2016/7/18.
 */
public class Solution188 {
    public int maxProfit(int k, int []prices){
        int len = prices.length;
        if(k >= len/2)
            return quickSolve(prices);

        int [][]maxProfit = new int[k+1][len];
        for(int i = 1; i <= k; i++){
            int maxTmp = -prices[0];
            for(int j = 1; j < len; j++){
                maxProfit[i][j] = Math.max(maxProfit[i][j-1], prices[j]+maxTmp); // compare profit with selling at day j or doing nothing
                maxTmp = Math.max(maxTmp, maxProfit[i-1][j-1]-prices[j]); // buy at day j
            }
        }
        return maxProfit[k][len-1];
    }

    private int quickSolve(int []prices){
        int len = prices.length, profit = 0;
        for(int i = 1; i < len; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
