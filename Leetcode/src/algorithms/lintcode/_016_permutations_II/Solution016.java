package algorithms.lintcode._016_permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Charlie on 2016/11/22. Tuesday
 */
public class Solution016 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }
        if (nums.length == 1) {
            permutations.add(new ArrayList<>(Arrays.asList(nums[0])));
            return permutations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (List<Integer> p : permuteUnique(removeIthNum(nums, i))) {
                    p.add(nums[i]);
                    permutations.add(p);
                }
            }
        }
        return permutations;
    }

    private int[] removeIthNum(int[] nums, int index) {
        int[] reducedNums = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
            if (i < index)
                reducedNums[i] = nums[i];
            else
                reducedNums[i] = nums[i+1];
        }
        return reducedNums;
    }
}
