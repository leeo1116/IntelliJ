package algorithms.lintcode._104_merge_k_sorted_lists;

import algorithms.lintcode.common.ListNode;

import java.util.List;

/**
 * Created by Charlie on 2017/2/9. Cloudy to Sunny
 */
public class Solution104 {
    // Method 1: leveraging merge2lists. StackoverflowError when input lists is too long
    public ListNode mergeKListsTraversal(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        else if (lists.size() == 1)
            return lists.get(0);
        else {
            ListNode h = merge2Lists(lists.get(0), lists.get(1));
            lists.remove(0);
            lists.remove(0);
            lists.add(0, h);
            return mergeKListsTraversal(lists);
        }
    }

    // Method 2: divide-and-conquer, still leveraging merge2Lists
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        return mergeHelper(lists, 0, lists.size()-1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end)
            return lists.get(start);
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode h = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if (l1 == null)
            h.next = l2;
        else
            h.next = l1;
        return dummyHead.next;
    }
}
