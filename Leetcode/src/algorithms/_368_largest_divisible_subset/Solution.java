package algorithms._368_largest_divisible_subset;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Charlie on 2016/7/7.
 */
public class Solution {
    public int[] largestDivisibleSubset(int []nums){
        if(nums.length < 2)
            return nums;
        Arrays.sort(nums);
        int []parent = new int[nums.length];
        int []count = new int[nums.length];
        int maxCount = 0, maxCountIndex = -1;
        for(int i = nums.length-1; i > -1; i--){
            for(int j = i; j < nums.length; j++){
                if(nums[j] % nums[i] == 0 && count[i] < 1+count[j]){
                    count[i] = 1+count[j];
                    parent[i] = j;
                    if(count[i] > maxCount){
                        maxCount = count[i];
                        maxCountIndex = i;
                    }
                }
            }
        }
        int []subset = new int[maxCount];
        for(int i = 0; i < maxCount; i++){
            subset[i] = nums[maxCountIndex];
            maxCountIndex = parent[maxCountIndex];
        }
        return subset;
    }
}
