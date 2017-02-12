package lintcode._135_combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Charlie on 2016/10/30. Sunday
 */
public class Solution135 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if (candidates.length == 0 || target < 1)
            return combinations;
        if (candidates.length == 1 && candidates[0] == target) {
            tmp.add(candidates[0]);
            combinations.add(tmp);
            return combinations;
        }

        for (int j = 0; j < candidates.length; j++) {

            int s = candidates[j];
            while (s <= target) {
                List<List<Integer>> subCombine = new ArrayList<List<Integer>>();
                List<Integer> c = new ArrayList<Integer>();
                int tmpS = s;
                if (tmpS == target) {
                    while (tmpS > 0) {
                        c.add(candidates[j]);
                        tmpS -= candidates[j];
                    }
                    subCombine.add(c);
                } else {
                    subCombine = combinationSum(Arrays.copyOfRange(candidates, j+1, candidates.length), target - s);
                    for (List<Integer> tmpC : subCombine) {
                        tmpS = s;
                        while (tmpS > 0) {
                            tmpC.add(0, candidates[j]);
                            tmpS -= candidates[j];
                        }
                    }
                }
                for (List<Integer> subC : subCombine) {
                    if (!combinations.contains(subC))
                        combinations.add(subC);
                }
                s += candidates[j];
            }
        }
        return combinations;
    }

    // From LeetCode
    public List<List<Integer>> combinationSumLeetcode(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> c = new ArrayList<Integer>();

        if (target == 0) {
            combinations.add(c);
            return combinations;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            List<List<Integer>> subComb = combinationSum(Arrays.copyOfRange(candidates, i, candidates.length), target-candidates[i]);
            for (List<Integer> sc : subComb)
                sc.add(0, candidates[i]);

            for (List<Integer> scTmp : subComb) {
                if (!combinations.contains(scTmp))
                    combinations.add(scTmp);
            }
        }
        return combinations;
    }
}
