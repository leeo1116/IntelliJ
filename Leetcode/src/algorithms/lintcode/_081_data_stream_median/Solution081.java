package algorithms.lintcode._081_data_stream_median;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Charlie on 2017/2/11. Sunny
 */
public class Solution081 {
    private Queue<Integer> small = new PriorityQueue<Integer>();
    private Queue<Integer> large = new PriorityQueue<Integer>();

    public int[] medianII(int[] nums) {
        int[] median = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
            median[i] = findMedian();
        }
        return median;
    }

    private void addNum(int num) {
        /* Alternative method
        small.add(-num);
        large.add(-small.poll());
         */
        large.add(num);
        small.add(-large.poll());
        // To harmonize the size of large and small
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    private int findMedian() {
        return large.size() > small.size() ? large.peek() : -small.peek();
    }
}
