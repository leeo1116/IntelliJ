package algorithms.lintcode._106_convert_sorted_list_to_balanced_BST;

import algorithms.lintcode.common.ListNode;
import algorithms.lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/16.Cloudy, Rainy
 */
public class Solution106 {
    // Create a 'pointer', since Java pass arguments by value, the later recursion need to pass head as an argument
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        // Get list length
        int listLen = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            listLen += 1;
        }
        // Set current node to head
        current = head;
        // Build balanced BST in bottom-up manner
        return sortedListToBalancedBST(head, listLen);
    }

    private TreeNode sortedListToBalancedBST(ListNode head, int len) {
        if (len < 1)
            return null;
        else {
            TreeNode left = sortedListToBalancedBST(head, len/2);
            TreeNode root = new TreeNode(current.val);
            current = current.next;
            TreeNode right = sortedListToBalancedBST(head, len-len/2-1);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
