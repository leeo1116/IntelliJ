package lintcode._073_construct_binary_tree_from_preorder_inorder_traversal;

import lintcode.common.TreeNode;

import java.util.Arrays;

/**
 * Created by Charlie on 2016/10/25. Tuesday
 */
public class Solution073 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findRootFromInorder(inorder, root);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }

    private int findRootFromInorder(int[] inorder, TreeNode root) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val)
                return i;
        }
        return -1;
    }
}
