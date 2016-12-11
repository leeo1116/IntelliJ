package algorithms.lintcode._017_subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Charlie on 2016/11/20. Sunday
 */
public class Solution017 {
    public ArrayList<ArrayList<Integer>> subsets1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        allSubsets.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int allSubsetsSize = allSubsets.size();
            for (int j = 0; j < allSubsetsSize; j++) {
                ArrayList<Integer> tmpSet = new ArrayList<Integer>(allSubsets.get(j));
                tmpSet.add(nums[i]);
                allSubsets.add(tmpSet);
            }
        }
        return allSubsets;
    }

    public ArrayList<ArrayList<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0)
                    subset.add(nums[j]);
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }
}
