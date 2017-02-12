package algorithms.lintcode._092_backpack;

/**
 * Created by Charlie on 2017/2/6. Snowy
 */
public class Solution092 {
    public int backpack(int m, int[] A) {
        int itemsNum = A.length;
        int[][] maxSpace = new int[itemsNum+1][m+1];
        maxSpace[0][0] = 0;
        for (int i = 1; i < itemsNum+1; i++) {
            for (int j = 0; j < m+1; j++) {
                maxSpace[i][j] = maxSpace[i-1][j];
                if (j >= A[i-1]) {
                    maxSpace[i][j] = Math.max(maxSpace[i-1][j], maxSpace[i-1][j-A[i-1]] + A[i-1]);
                }
            }
        }
        return maxSpace[itemsNum][m];
    }
}
