package lintcode._121_word_ladder_II;

import java.util.*;

/**
 * Created by Liang on 12/11/16. Sunday
 */
public class Solution121 {
    Map<String, List<String>> vertexNeighborsMap;
    List<List<String>> words;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        words = new ArrayList<List<String>>();
        if (dict.size() == 0) return words;  // if |start-end| = 1, should add start and end to words?

        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<String>();
        vertexNeighborsMap = new HashMap<String, List<String>>();  // {vertex: [neighbor0, ..., neighborN]}
        Map<String, Integer> ladder = new HashMap<String, Integer>();  // {word: steps from start word to current word}

        queue.add(start);  // initialize queue with start word
        dict.add(end);

        for (String word : dict)
            ladder.put(word, Integer.MAX_VALUE);

        ladder.put(start, 0);


        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) break;  // end word may have next word, no need to visit word after end word

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();

                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord))  // it implies newWord is visited
                            continue;
                        else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }

                        if (vertexNeighborsMap.containsKey(newWord)) {
                            vertexNeighborsMap.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            vertexNeighborsMap.put(newWord, list);
                        }

                        if (newWord.equals(end))
                            min = step;  // end word may still have next word
                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<String>();
        backTrace(end, start, result);
        return words;
    }


    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {  // if end word equals to start word
            list.add(0, start);
            words.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }

        list.add(0, word);
        if (vertexNeighborsMap.get(word) != null) {
            for (String s : vertexNeighborsMap.get(word)) {
                backTrace(s, start, list);
            }
        }
        list.remove(0);
    }

}