package algorithms.lintcode;

import algorithms.leetcode._179_largest_number.Solution;
import algorithms.lintcode._007_binary_tree_serialization.Solution007;
import algorithms.lintcode._098_sort_list.Solution098;
import algorithms.lintcode._105_copy_list_with_random_pointer.Solution105;
import algorithms.lintcode._106_convert_sorted_list_to_balanced_BST.Solution106;
import algorithms.lintcode._113_remove_duplicates_from_sorted_list_II.Solution113;
import algorithms.lintcode._135_combination_sum.Solution135;
import algorithms.lintcode.common.ListNode;
import algorithms.lintcode.common.RandomListNode;
import algorithms.lintcode.common.TreeNode;

/**
 * Created by Charlie on 2016/10/16. Sunday
 */
public class TestDriver {
    // 106. Sorted linked list to balanced BST
    private static ListNode head = new ListNode(-1);
    // 105. Copy list with random pointer
    private static RandomListNode h = new RandomListNode(-1);

    public static void main (String[] args) {
        // Solution106
        head.next = new ListNode(1);
        Solution106 s106 = new Solution106();
        Solution106 s106Copy = s106;
        assert s106Copy == s106;
        s106.sortedListToBST(head);
        // Solution105
        h.next = new RandomListNode(1);
        Solution105 s105 = new Solution105();
        s105.copyRandomList(h);
        // Solution098
        ListNode head098 = new ListNode(1);
        head098.next = new ListNode(-1);
        head098.next.next = null;
        Solution098 s098 = new Solution098();
        s098.sortList(head098);
        // Solution113
        ListNode head113 = new ListNode(1);
        head113.next = new ListNode(1);
        head113.next.next = new ListNode(2);
        Solution113.deleteDuplicates(head113);
        // Solution007
        Solution007 s007 = new Solution007();
        TreeNode root007 = new TreeNode(1);
        root007.left = new TreeNode(26);
        root007.left.left = new TreeNode(3);
        root007.left.left.left = new TreeNode(4);
        String data = s007.serialize(root007);
        System.out.println(s007.serialize(s007.deserialize(data)));
        // SOlution135
        Solution135 s135 = new Solution135();
        int[] candidates = {1};
        System.out.println(s135.combinationSumLeetcode(candidates, 1));
    }

}
