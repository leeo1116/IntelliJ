package algorithms.leetcode._375_guess_number_higher_or_lower_II;

/**
 * Find out the minimum money that it is guaranteed to win
 * Created by Charlie on 2016/7/22.
 */
public class Solution375 {
    public int getMoneyAmount(int n){
        // minimum to pay in order to win from number i to j
        int [][]minPayIJ = new int[n+1][n+1];
        return DP(minPayIJ, 1, n);
    }

    private int DP(int [][]table, int start, int end){
        if(start >= end)
            return 0;
        if(table[start][end] != 0)
            return table[start][end];
        int minPay = Integer.MAX_VALUE;
        for(int n = start; n <= end; n++){
            int tmp = n+Math.max(DP(table, start, n-1), DP(table, n+1, end));
            minPay = Math.min(minPay, tmp);
        }
        table[start][end] = minPay;
        return minPay;
    }
}
