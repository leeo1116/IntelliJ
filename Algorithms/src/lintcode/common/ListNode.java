package algorithms.lintcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void printLinkedList(ListNode h) {
        while (h != null) {
            System.out.print(Integer.toString(h.val)+" -> ");
            h = h.next;
        }
    }

    public static void printLinkedList(ListNode h, int n) {
        while (n > 0) {
            System.out.print(Integer.toString(h.val)+" -> ");
            n -= 1;
        }
    }
}
