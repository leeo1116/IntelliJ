package algorithms.lintcode._102_linked_list_cycle;

import algorithms.lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/22.Saturday
 */
public class Solution102 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1 == p2;
    }
}
