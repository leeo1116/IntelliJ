package lintcode._099_reorder_list;

import lintcode.common.ListNode;

import java.util.List;

/**
 * Created by Charlie on 2016/10/22.Saturday
 */
public class Solution099 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // Find middle node
        ListNode mid = findMiddleNode(head);
        // and cut linked list into half
        ListNode midNext = mid.next;
        mid.next = null;
        // Reverse nodes from middle to end
        ListNode revHead = reverseLinkedList(midNext);
        // Merge nodes from start to middle and reversed nodes
        ListNode headTmp = head;
        mergeTwoLinkedLists(headTmp, revHead);
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode p = null, q;
        while (head != null) {
            q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }

    private void mergeTwoLinkedLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode head1Next = head1.next;
            ListNode head2Next = head2.next;
            head1.next = head2;
            head2.next = head1Next;
            head1 = head1Next;
            head2 = head2Next;
        }
    }
}
