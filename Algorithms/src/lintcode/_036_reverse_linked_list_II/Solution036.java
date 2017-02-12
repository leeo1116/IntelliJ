package lintcode._036_reverse_linked_list_II;

import lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/23. Sunday
 */
public class Solution036 {
    public ListNode reverseLinkedList(ListNode head, int m, int n) {
        if (m == n) return head;
        // Find (m-1)th node, leverage dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mPre = findKthNode(dummy, m);
        // Find (n+1)th node
        ListNode nNext = findKthNode(dummy, n+2);
        // Reverse nodes from m to n
        ListNode p = nNext, h = mPre.next, q;
        while (h != nNext) {
            q = h.next;
            h.next = p;
            p = h;
            h = q;
        }
        mPre.next = p;
        return dummy.next;
    }

    private ListNode findKthNode(ListNode head, int k) {
        while (k > 1) {
            head = head.next;
            k -= 1;
        }
        return head;
    }
}
