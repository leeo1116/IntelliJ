package algorithms.lintcode._118_distinct_subsequences;

/**
 * Created by Charlie on 2017/2/6. Snowy
 */
public class Solution118 {
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] distinctSeq = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            distinctSeq[i][0] = 1;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    distinctSeq[i][j] = distinctSeq[i-1][j-1] + distinctSeq[i-1][j];
                } else {
                    distinctSeq[i][j] = distinctSeq[i-1][j];
                }
            }
        }
        return distinctSeq[m][n];
    }
}
