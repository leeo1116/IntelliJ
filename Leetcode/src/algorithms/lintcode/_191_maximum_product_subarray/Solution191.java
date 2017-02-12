package algorithms.lintcode._191_maximum_product_subarray;

/**
 * Created by Charlie on 2017/2/5. Cloudy
 */
public class Solution191 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        min[0] = max[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i] * max[i-1], nums[i]);
                min[i] = Math.min(nums[i] * min[i-1], nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(nums[i] * min[i-1], nums[i]);
                min[i] = Math.min(nums[i] * max[i-1], nums[i]);
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }
}
