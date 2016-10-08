package algorithms._179_largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String []numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsStr[i] = nums[i]+"";
        }

        // class template: Comparator
        Comparator<String> comp = new Comparator<String>() {
            // virtual function in class template
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };

        Arrays.sort(numsStr, comp);
        if(numsStr[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : numsStr)
            sb.append(s);

        return sb.toString();
    }

    // Test driver
    public static void main(String []args){
        int []num = {0, 0};
        Solution s = new Solution();
        System.out.print(s.largestNumber(num));

    }
}
