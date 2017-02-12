package lintcode._152_combinations;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 2016/10/29.Saturday
 */
public class Solution152 {
    public List<List<Integer>> combine(int n, int k) {
        return  combineHelper(1, n, k);
    }

    private List<List<Integer>> combineHelper(int min, int max, int k){
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (k == 0) return combinations;
        if (k == 1) {
            List<Integer> tmp;
            for (int i = min; i <= max; i++) {
                tmp = new ArrayList<Integer>();
                tmp.add(i);
                combinations.add(tmp);
            }
            return combinations;
        }
        if (max - min +1 <= k) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = min; i <= max; i++)
                tmp.add(i);
            combinations.add(tmp);
            return combinations;
        }
        List<List<Integer>> subCombine1 = combineHelper(min+1, max, k-1);
        for (List<Integer> c : subCombine1) {
            c.add(0, min);
        }
        List<List<Integer>> subCombine2 = combineHelper(min+1, max, k);
        combinations.addAll(subCombine1);
        combinations.addAll(subCombine2);
        return combinations;
    }
}
