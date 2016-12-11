package lintcode._093_balanced_binary_tree;

import lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/24. Monday
 */
public class Solution093 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left)-maxDepth(root.right)) > 1)
            return false;
        if (isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
