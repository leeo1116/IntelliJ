package algorithms.lintcode._029_interleaving_string;

/**
 * Created by Charlie on 2017/2/4. Rainy
 */
public class Solution029 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        boolean[][] isInterleave = new boolean[n1+1][n2+1];
        isInterleave[0][0] = true;
        for (int i = 1; i < n1+1; i++) {
            if (s3.charAt(i-1) == s1.charAt(i-1))
                isInterleave[i][0] = true;
        }
        for (int j = 1; j < n2+1; j++) {
            if (s3.charAt(j-1) == s2.charAt(j-1))
                isInterleave[0][j] = true;
        }
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (isInterleave[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1)
                        || isInterleave[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
                    isInterleave[i][j] = true;
                else {
                    isInterleave[i][j] = false;
                }
            }
        }
        return isInterleave[n1][n2];
    }
}
