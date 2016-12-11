package lintcode._120_word_ladder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Charlie on 2016/11/5. Saturday
 */
public class Solution120 {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 1;
        Queue<String> queue = new LinkedList<String>();
        int layerNum = 2;
        dict.add(end);  // universally process all strings in dict
        dict.remove(start); // in case dict contains start word
        for (int i = 0; i < start.length(); i ++) {
            for (int j = 0; j < 26; j ++) {
                String nextWord = start.substring(0, i) + (char)('a'+j) + start.substring(i+1);
                if (nextWord.equals(end)) return layerNum;
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
                if (word.equals(end)) return layerNum;
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
            layerNum ++;
        }
        return 0;
    }
}
