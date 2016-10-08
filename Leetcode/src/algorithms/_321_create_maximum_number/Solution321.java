package algorithms._321_create_maximum_number;


public class Solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int []maxNum = new int[k];
        for(int i = Math.max(0, k-n2); i <= k && i <= n1; i++){
            int []candidate = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(greater(candidate, 0, maxNum, 0))
                maxNum = candidate;
        }
        return maxNum;
    }

    private int[] merge(int []nums1, int []nums2, int k){
        int []maxNum = new int[k];
        for(int i = 0, j = 0, r = 0; r < k; r++)
            maxNum[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return maxNum;
    }

    private boolean greater(int []nums1, int i, int []nums2, int j){
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int []nums, int k){
        int n = nums.length;
        int []maxArray = new int[k];
        for(int i = 0, j = 0; i < n; i++){
            // while the remaining numbers + current j numbers is greater than k, and j > 0 and previous max digit is smaller than current nums[i]
            while (n-i+j > k && j > 0 && maxArray[j-1] < nums[i])
                j--;
            // use a cursor j for a array with length k to maintain max array
            if(j < k)
                maxArray[j++] = nums[i];
        }
        return maxArray;
    }
}
