package algorithms.lintcode._124_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Charlie on 2017/2/8. Rainy
 */
public class Solution124 {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        Set<Integer> numSet = new HashSet<Integer>();
        int max = 1;
        for (int n : num) numSet.add(n);
        for (int n : num) {
            int left = n - 1, right = n + 1, count = 1;
            while (numSet.contains(left)) {
                count++;
                numSet.remove(left);
                left--;
            }
            while (numSet.contains(right)) {
                count++;
                numSet.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
