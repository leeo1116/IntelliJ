package lintcode._103_linked_list_cycle;

import lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/23. Sunday
 */
public class Solution103 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        // Meet in the cycle
        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null && p1 != p2) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        if (p2 == null || p2.next == null) return null;
        p1 = p1.next;
        while (p1 != head) {
            p1 = p1.next;
            head = head.next;
        }
        return p1;
    }
}
