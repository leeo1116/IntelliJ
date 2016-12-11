package algorithms.lintcode._085_insert_node_in_a_binary_search_tree;

import algorithms.lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/24. Monday
 */
public class Solution085 {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (root.left == null && node.val < root.val) root.left = node;
        if (root.right == null && node.val > root.val) root.right = node;
        if (node.val > root.val) insertNode(root.right, node);
        if (node.val < root.val) insertNode(root.left, node);
        return root;
    }
}
