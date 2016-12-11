package algorithms.lintcode._097_maximum_depth_of_binary_tree;

import algorithms.lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/24. Monday
 */
public class Solution097 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
