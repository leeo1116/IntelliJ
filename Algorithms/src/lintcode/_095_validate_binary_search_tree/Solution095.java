package lintcode._095_validate_binary_search_tree;

import lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/24. Monday
 */
public class Solution095 {
    private boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;
        if (minNode != null && minNode.val >= root.val || maxNode != null && maxNode.val <= root.val)
            return false;
        return isValidBSTHelper(root.left, minNode, root) && isValidBSTHelper(root.right, root, maxNode);
    }
}
