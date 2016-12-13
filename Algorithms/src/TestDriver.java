import lintcode._007_binary_tree_serialization.Solution007;
import lintcode._015_permutations.Solution015;
import lintcode._017_subsets.Solution017;
import lintcode._018_subsets_II.Solution018;
import lintcode._033_N_queens.Solution033;
import lintcode._098_sort_list.Solution098;
import lintcode._105_copy_list_with_random_pointer.Solution105;
import lintcode._106_convert_sorted_list_to_balanced_BST.Solution106;
import lintcode._113_remove_duplicates_from_sorted_list_II.Solution113;
import lintcode._120_word_ladder.Solution120;
import lintcode._121_word_ladder_II.Solution121;
import lintcode._135_combination_sum.Solution135;
import lintcode.common.ListNode;
import lintcode.common.RandomListNode;
import lintcode.common.TreeNode;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Charlie on 2016/10/16. Sunday
 */
public class TestDriver {
    // 106. Sorted linked list to balanced BST
    private static ListNode head = new ListNode(-1);
    // 105. Copy list with random pointer
    private static RandomListNode h = new RandomListNode(-1);

    public static void main(String[] args) {
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

        // Solution135
        Solution135 s135 = new Solution135();
        int[] candidates = {1};
        System.out.println(s135.combinationSumLeetcode(candidates, 1));

        // Solution120
        Solution120 s120 = new Solution120();
        System.out.println(s120.ladderLength("game", "thee", new HashSet<String>(Arrays.asList("frye", "heat", "tree", "thee", "game", "free", "hell", "fame", "faye"))));
        System.out.println(s120.ladderLength("a", "c", new HashSet<String>(Arrays.asList("a", "b", "c"))));
        System.out.println(s120.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

        // Solution033
        Solution033 s33 = new Solution033();
        s33.solveNQueens(1);

        // Solution017
        Solution017 s017 = new Solution017();
        s017.subsets1(new int[]{1, 2, 3});

        // Solution018
        Solution018 s018 = new Solution018();
        s018.subsetsWithDup(new int[]{1, 2, 2});

        // Solution015
        Solution015 s015 = new Solution015();
        s015.permute(new int[]{});

        // Solution121
        Solution121 s121 = new Solution121();
        System.out.println(s121.findLadders("hit", "cog", new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }

}
