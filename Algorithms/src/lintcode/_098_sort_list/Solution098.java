package lintcode._098_sort_list;

import lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/23.Sunday
 */
public class Solution098 {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        // Find middle node
        ListNode mid = findMiddleNode(head);
        // Cut in the middle
        ListNode midNext = mid.next;
        mid.next = null;
        // Sort right part
        ListNode right;
        if (midNext != null)
            right = sortList(midNext);
        else return head;
        // Sort left part
        ListNode left = sortList(head);
        // Merge left and right
        return mergeTwoSortedLinkedList(left, right);
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            if (p2 == null) break;
            p1 = p1.next;

        }
        return p1;
    }

    private ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2) {
        if (head2 == null) return head1;
        ListNode head = head1;
        if (head1.val > head2.val) head = head2;
        ListNode h = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                h.next = head1;
                head1 = head1.next;
            } else {
                h.next = head2;
                head2 = head2.next;
            }
            h = h.next;
        }
        if (head1 == null) {
            while (head2 != null) {
                h.next = head2;
                head2 = head2.next;
                h = h.next;
            }
        } else {
            while (head1 != null) {
                h.next = head1;
                head1 = head1.next;
                h = h.next;
            }
        }
        return head;
    }
}
