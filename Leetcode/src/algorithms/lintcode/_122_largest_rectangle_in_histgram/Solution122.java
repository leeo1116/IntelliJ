package algorithms.lintcode._122_largest_rectangle_in_histgram;

import java.util.Stack;

/**
 * Created by Charlie on 2017/2/11. Sunny
 */
public class Solution122 {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < height.length + 1; i++) {
            int h = (i == height.length) ? -1 : height[i];
            while (!stack.empty() && h <= height[stack.peek()]) {
                int lastMaxHeight = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, lastMaxHeight * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
