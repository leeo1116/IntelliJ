package lintcode._165_merge_two_sorted_lists;

import lintcode.common.ListNode;

public class Solution165 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode l3 = h;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            } else if (l2 == null) {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            } else if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            } else if (l2.val <= l1.val) {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        return h.next;
    }
}
