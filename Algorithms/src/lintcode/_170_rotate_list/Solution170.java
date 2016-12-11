package lintcode._170_rotate_list;

import lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/13. Rainy
 */
public class Solution170 {
    public ListNode rotateRight(ListNode head, int k) {
        // If k == 0, no need to rotate
        if (k == 0 || head == null) return head;
        ListNode p1 = head, p2 = head, p = head;
        // Get size of linked list
        int listSize = 0;
        while (p != null) {
            listSize += 1;
            p = p.next;
        }
        // In case k > listSize
        k = k%listSize;
        // If new k == 0, return head
        if (k == 0) return head;
        // Let p2 lead p1 by k nodes
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return head;
            }
            p2 = p2.next;
        }
        // Move both p1 and p2 until p2 reaches the end (null)
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // Append all nodes before newHead to the end
        p2.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }
}
