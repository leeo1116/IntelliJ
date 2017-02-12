package algorithms.lintcode._109_triangle;

/**
 * Created by Charlie on 2017/2/4. Cloudy
 */
public class Solution109 {
    // A top-down solution
    public int minimumTotal(int[][] triangle) {
        // Validation
        if (triangle == null
                || triangle.length == 0
                || triangle[0] == null
                || triangle[0].length == 0)
            return -1;

        // Maintain a path sum matrix
        int row = triangle.length;
        int[][] pathSum = new int[row][row]; // minimum path sum from [0][0] to [i][j]

        // Initialization
        pathSum[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            pathSum[i][0] = pathSum[i-1][0] + triangle[i][0];  // left edge of triangle
            pathSum[i][i] = pathSum[i-1][i-1] + triangle[i][i];  // right edge of triangle
        }

        // Calculate min path sum
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < i; j++) {
                pathSum[i][j] = Math.min(pathSum[i-1][j], pathSum[i-1][j-1]) + triangle[i][j];
            }
        }

        // Find minimum path sum
        int minPathSum = pathSum[row-1][0];
        for (int i = 0; i < row; i++) {
            minPathSum = Math.min(minPathSum, pathSum[row-1][i]);
        }

        return minPathSum;
    }
}
