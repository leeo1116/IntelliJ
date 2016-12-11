package lintcode._105_copy_list_with_random_pointer;

import lintcode.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Charlie on 2016/10/17. Monday
 */
public class Solution105 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeNewNode = new HashMap<>();
        RandomListNode dummyH = new RandomListNode(0);
        RandomListNode dummyP = new RandomListNode(0);
        dummyH.next = head;
        RandomListNode h0 = dummyH;
        RandomListNode p0 = dummyP;
        // Round 1: Copy each node and its 'next'
        while (h0.next != null) {
            p0.next = new RandomListNode(h0.next.label);
            nodeNewNode.put(h0.next, p0.next);
            p0 = p0.next;
            h0 = h0.next;
        }
        p0.next = null;

        // Round 2: Copy 'random' of each node
        RandomListNode h1 = dummyH;
        RandomListNode p1 = dummyP;
        while (h1.next != null) {
            if (h1.next.random != null) {
                if (nodeNewNode.containsKey(h1.next.random)) {
                    p1.next.random = nodeNewNode.get(h1.next.random);
                } else {
                    p1.next.random = new RandomListNode(h1.next.random.label);
                }
            } else {
                p1.next.random = null;
            }
            h1 = h1.next;
            p1 = p1.next;
        }
        return dummyP.next;
    }

    public RandomListNode deepCopyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeNewNode = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newDummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode h = dummy;
        RandomListNode newH = newDummy;
        while (h != null) {
            if (nodeNewNode.containsKey(h.next)) {
                newH.next = nodeNewNode.get(h.next);
            } else {
                if (h.next != null) {
                    newH.next = new RandomListNode(h.next.label);
                    nodeNewNode.put(h.next, newH.next);
                } else {
                    newH.next = null;
                }
            }
            if (nodeNewNode.containsKey(h.random)) {
                newH.random = nodeNewNode.get(h.random);
            } else {
                if (h.random != null) {
                    newH.random = new RandomListNode(h.random.label);
                    nodeNewNode.put(h.random, newH.random);
                } else {
                    newH.random = null;
                }

            }
            h = h.next;
            newH = newH.next;
        }
        return newDummy.next;
    }
}
