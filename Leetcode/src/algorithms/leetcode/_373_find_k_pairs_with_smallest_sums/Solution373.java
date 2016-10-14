package algorithms.leetcode._373_find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integer arrays nums1, nums2 in ascending order, find k paris (n1 n2) with smallest sums. n1, n2 is number
 * from nums1 and nums2 respectively
 * Created by Charlie on 2016/7/22.
 */
public class Solution373 {
    public List<int []> kSmallestPairs(int []nums1, int []nums2, int k){
        List<int []> minPairs = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return minPairs;

        int []index = new int[nums1.length];
        while(k > 0){
            int minSum = Integer.MAX_VALUE;
            int i = -1;
            for(int j = 0; j < nums1.length; j++){
                if(index[j] >= nums2.length)
                    continue;
                if(nums1[j]+nums2[index[j]] < minSum){
                    minSum = nums1[j]+nums2[index[j]];
                    i = j;
                }
            }
            if( i == -1)
                break;
            minPairs.add(new int []{nums1[i], nums2[index[i]]});
            index[i]++;
            k--;
        }
        return minPairs;
    }
}
