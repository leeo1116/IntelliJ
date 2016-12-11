package algorithms.lintcode._018_subsets_II;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Charlie on 2016/11/20. Sunday
 */
public class Solution018 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        allSubsets.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int allSubsetsSize = allSubsets.size(), k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                k = allSubsetsSize;
            else k = 0;
            allSubsetsSize = allSubsets.size();
            for (int j = k; j < allSubsetsSize; j++) {
                ArrayList<Integer> tmpSet = new ArrayList<Integer>(allSubsets.get(j));
                tmpSet.add(nums[i]);
                allSubsets.add(tmpSet);
            }
        }
        return allSubsets;
    }
}
