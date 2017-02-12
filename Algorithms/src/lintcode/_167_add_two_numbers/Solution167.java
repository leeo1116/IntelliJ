package lintcode._167_add_two_numbers;

import lintcode.common.ListNode;

/**
 * Created by Charlie on 2016/10/23.Sunday
 */
public class Solution167 {
    public ListNode addLinkedLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carryIn = 0, digitSum;
        while (l1 != null && l2 != null) {
            digitSum = (l1.val + l2.val + carryIn) % 10;
            carryIn = (l1.val + l2.val + carryIn) / 10;
            l3.next = new ListNode(digitSum);
            l3 = l3.next;
            l2 = l2.next;
            l1 = l1.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                digitSum = (l2.val + carryIn) % 10;
                carryIn = (l2.val + carryIn) / 10;
                l3.next = new ListNode(digitSum);
                l3 = l3.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                digitSum = (l1.val + carryIn) % 10;
                carryIn = (l1.val + carryIn) / 10;
                l3.next = new ListNode(digitSum);
                l3 = l3.next;
                l1 = l1.next;
            }
        }
        if (carryIn != 0) l3.next = new ListNode(carryIn);
        return head.next;
    }
}
