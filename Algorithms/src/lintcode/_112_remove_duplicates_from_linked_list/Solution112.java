package algorithms.lintcode._112_remove_duplicates_from_linked_list;

import algorithms.lintcode.common.ListNode;

public class Solution112 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        while (h != null && h.next != null) {
            while (h.next != null && h.val == h.next.val) {
                h.next = h.next.next;
            }
            h = h.next;
        }
        return head;
    }
}
