package algorithms.lintcode._166_Nth_to_last_node_in_list;

import algorithms.lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/23.Sunday
 */
public class Solution166 {
    public ListNode nthToLast(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        while (n > 0) {
            p2 = p2.next;
            n -= 1;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.next;
    }
}
