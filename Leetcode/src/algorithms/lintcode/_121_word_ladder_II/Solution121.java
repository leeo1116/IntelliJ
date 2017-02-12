package algorithms.lintcode._121_word_ladder_II;

import algorithms.lintcode.common.ListNode;

import java.util.*;

/**
 * Created by Charlie on 2016/11/22. Tuesday
 */
public class Solution121 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        List<String > ladder = new ArrayList<String>();
        ladders.add(Arrays.asList(start));
        if (start.equals(end)) return ladders;
        Queue<String> queue = new LinkedList<String>();
        dict.add(end);  // universally process all strings in dict
        dict.remove(start); // in case dict contains start word
        for (int i = 0; i < start.length(); i ++) {
            for (int j = 0; j < 26; j ++) {
                String nextWord = start.substring(0, i) + (char)('a'+j) + start.substring(i+1);
                if (dict.contains(nextWord)) {
                    queue.offer(nextWord);
                    dict.remove(nextWord);
                }
            }
        }
        while (!queue.isEmpty()) {
            int queueSize = queue.size();  // The size of queue is equal to the number of nodes in current 'layer'
            for (int i = 0; i < queueSize; i++) {
                String word = queue.poll();
                ladder.add(word);
                if (word.equals(end)) ladders.add(ladder);
                // Enqueue all unvisited neighbors, i.e. next words to visit
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String nextWord = word.substring(0, j) + (char)('a' + k) + word.substring(j + 1);
                        if (dict.contains(nextWord)) {
                            queue.offer(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                }
            }
        }
        return ladders;
    }
}
