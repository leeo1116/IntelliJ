package algorithms.lintcode._004_ugly_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 2017/2/11. Sunny
 */
public class Solution004 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[p2] * 2, Math.min(uglyNums[p3] * 3, uglyNums[p5] * 5));
            if (uglyNums[i] == uglyNums[p2] * 2) p2++;
            if (uglyNums[i] == uglyNums[p3] * 3) p3++;
            if (uglyNums[i] == uglyNums[p5] * 5) p5++;
        }
        return uglyNums[n-1];
    }
}
