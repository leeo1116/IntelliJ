package algorithms.lintcode._066_binary_tree_preorder_traversal;

import algorithms.lintcode.common.ListNode;
import algorithms.lintcode.common.TreeNode;

import java.util.ArrayList;

/**
 * Created by Charlie on 2016/10/24. Monday
 */
public class Solution066 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        preorderTraversalHelper(root, nodes);
        return nodes;
    }

    private ArrayList<Integer> preorderTraversalHelper(TreeNode root, ArrayList<Integer> nodes) {
        if (root == null) return nodes;
        nodes.add(root.val);
        nodes.addAll(preorderTraversalHelper(root.left, new ArrayList<Integer>()));
        nodes.addAll(preorderTraversalHelper(root.right, new ArrayList<Integer>()));
        return nodes;
    }
}
