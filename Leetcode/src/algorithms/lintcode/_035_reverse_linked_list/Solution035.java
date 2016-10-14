package algorithms.lintcode._035_reverse_linked_list;

import algorithms.lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/13. Rainy
 */
public class Solution035 {
    public ListNode reverse(ListNode head) {
        ListNode p = null, q;
        while (head != null) {
            q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }
}
