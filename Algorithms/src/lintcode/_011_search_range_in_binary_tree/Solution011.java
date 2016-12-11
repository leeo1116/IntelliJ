package algorithms.lintcode._011_search_range_in_binary_tree;

import algorithms.lintcode.common.TreeNode;

import java.util.ArrayList;

/**
 * Created by Charlie on 2016/10/26. Wednesday
 */
public class Solution011 {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        if (root == null || k2 < k1) return nodes;
        if (root.val < k1)
            return searchRange(root.right, k1, k2);
        if (root.val > k2)
            return searchRange(root.left, k1, k2);
        if (k1 <= root.val && root.val <= k2) {
            nodes.addAll(searchRange(root.left, k1, k2));
            nodes.add(root.val);
            nodes.addAll(searchRange(root.right, k1, k2));
        }
        return nodes;
    }
}
