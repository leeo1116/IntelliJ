package algorithms.leetcode._307_range_sum_query_mutable;


public class NumArray {
    private int []nums;
    private int []BIT;
    private int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n+1];
        for(int i = 0; i < n; i++)
            constructBIT(i, nums[i]);
    }

    void update(int i, int val) {
        int diff = val-nums[i];
        nums[i] = val;
        constructBIT(i, diff);
    }

    public int sumRange(int i, int j){
        return getSum(j)-getSum(i-1);
    }

    /**
     * Get sum of first i nodes, 0, 1, ..., i
     * @param i index last element
     * @return sum of first i nodes
     */
    private int getSum(int i) {
        int sum = 0;
        i++;
        while(i > 0){
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    private void constructBIT(int i, int num) {
        i++;
        while(i <= n){
            BIT[i] += num;
            i += (i & -i);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
