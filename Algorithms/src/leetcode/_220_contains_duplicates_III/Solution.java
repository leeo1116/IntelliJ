package leetcode._220_contains_duplicates_III;

import static java.lang.Math.abs;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length && j <= i+k; j++){
                if((nums[j]-nums[i]) <= t && (nums[i]-nums[j]) <= t)
                return true;
            }
        }
        return false;
    }
}
