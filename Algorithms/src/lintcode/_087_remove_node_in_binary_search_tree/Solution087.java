package lintcode._087_remove_node_in_binary_search_tree;

import lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/29. Saturday
 */
public class Solution087 {
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findParentOfTargetNode(dummy, root, value);
        TreeNode node = null;
        if (parent.left != null && parent.left.val == value)
            node = parent.left;
        else if (parent.right != null && parent.right.val == value)
            node = parent.right;
        else
            return dummy.left;
        deleteTargetNode(parent, node);
        return dummy.left;
    }

    private TreeNode findParentOfTargetNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) return parent;
        if (node.val == value) return parent;
        if (node.val < value)
            return findParentOfTargetNode(node, node.right, value);
        else
            return findParentOfTargetNode(node, node.left, value);
    }

    private TreeNode deleteTargetNode(TreeNode parent, TreeNode node) {
        if (node == parent.left) {
            if (node.left == null && node.right == null)
                parent.left = null;
            else if (node.left != null && node.right == null)
                parent.left = node.left;
            else if (node.right != null && node.left == null)
                parent.left = node.right;
            else {
                if (node.right.left == null) {
                    node.val = node.right.val;
                    node.right = node.right.right;
                }
                else {
                    TreeNode nodeTmp = node.right.left;
                    TreeNode parentTmp = node.right;
                    // Find the node with minimum value
                    while (nodeTmp.left != null) {
                        nodeTmp = nodeTmp.left;
                        parentTmp = parentTmp.left;
                    }
                    node.val = nodeTmp.val;
                    parentTmp.left = null;
                }
            }
        } else {
            if (node.left == null && node.right == null)
                parent.right = null;
            else if (node.left != null && node.right == null)
                parent.right = node.left;
            else if (node.right != null && node.left == null)
                parent.right = node.right;
            else {
                if (node.right.left == null) {
                    node.val = node.right.val;
                    node.right = node.right.right;
                }
                else {
                    TreeNode nodeTmp = node.right.left;
                    TreeNode parentTmp = node.right;
                    // Find the node with minimum value
                    while (nodeTmp.left != null) {
                        nodeTmp = nodeTmp.left;
                        parentTmp = parentTmp.left;
                    }
                    node.val = nodeTmp.val;
                    parentTmp.left = null;
                }
            }
        }
        return parent;
    }
}
