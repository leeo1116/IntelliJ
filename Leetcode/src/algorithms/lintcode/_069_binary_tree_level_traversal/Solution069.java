package algorithms.lintcode._069_binary_tree_level_traversal;

import algorithms.lintcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Charlie on 2016/10/25. Tuesday
 */
public class Solution069 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
        if (root == null) return nodes;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> queueTmp = new ArrayDeque<TreeNode>();
        ArrayList<Integer> nodesTmp = new ArrayList<Integer>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            if (peek.left != null) queueTmp.add(peek.left);
            if (peek.right != null) queueTmp.add(peek.right);
            nodesTmp.add(peek.val);
            if (queue.isEmpty()) {
                nodes.add(nodesTmp);
                queue.addAll(queueTmp);
                nodesTmp = new ArrayList<Integer>();
                queueTmp = new ArrayDeque<TreeNode>();
            }
        }
        return nodes;
    }
}
