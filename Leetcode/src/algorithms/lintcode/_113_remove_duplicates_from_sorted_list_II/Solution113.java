package algorithms.lintcode._113_remove_duplicates_from_sorted_list_II;

import algorithms.lintcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Charlie on 2016/10/23. Sunday
 */
public class Solution113 {
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> nodeDoExist = new HashMap<Integer, Integer>();
        ListNode h = head;
        while (h != null) {
            nodeDoExist.put(h.val, nodeDoExist.getOrDefault(h.val, 0) + 1);
            h = h.next;
        }
        ListNode dummy = new ListNode(0);
        h = dummy;
        h.next = head;
        while (h != null && h.next != null) {
            ListNode hNext = h.next;
            while (hNext != null && nodeDoExist.get(hNext.val) > 1) {
                hNext = hNext.next;
            }
            h.next = hNext;
            h = h.next;
        }
        return dummy.next;
    }
}
