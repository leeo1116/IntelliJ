package main;


import algorithms.lintcode._096_partition_list.Solution096;
import algorithms.lintcode.common.ListNode;

public class TestDriver {

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(8);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        ListNode.printLinkedList(Solution096.partition(head, 5), 5);
    }

}
