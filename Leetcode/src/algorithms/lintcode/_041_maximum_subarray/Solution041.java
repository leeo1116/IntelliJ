package algorithms.lintcode._041_maximum_subarray;

/**
 * Created by Charlie on 2017/2/4. Rainy
 */
public class Solution041 {
    public int maxSubarray(int[] nums) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
