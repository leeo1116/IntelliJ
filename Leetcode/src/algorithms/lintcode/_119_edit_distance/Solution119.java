package algorithms.lintcode._119_edit_distance;

/**
 * Created by Charlie on 2017/2/5. Rainy
 */
public class Solution119 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] minDistance = new int[n1+1][n2+1];

        for (int i = 0; i < n1+1; i++) {
            minDistance[i][0] = i;
        }

        for (int j = 0; j < n2+1; j++) {
            minDistance[0][j] = j;
        }

        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    minDistance[i][j] = minDistance[i-1][j-1];
                } else {
                    minDistance[i][j] = Math.min(minDistance[i-1][j-1], Math.min(minDistance[i-1][j], minDistance[i][j-1])) + 1;
                }
            }
        }
        return minDistance[n1][n2];
    }
}
