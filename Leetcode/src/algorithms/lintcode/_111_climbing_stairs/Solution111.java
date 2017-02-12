package algorithms.lintcode._111_climbing_stairs;

/**
 * Created by Charlie on 2017/2/4. Rainy to Cloudy
 */
public class Solution111 {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        int[] steps = new int[n+1];
        for (int i = 0; i < n+1; i ++) {
            if (i <= 1)
                steps[i] = 1;
            else
                steps[i] = steps[i-2] + steps[i-1];
        }
        return steps[n];
    }
}
