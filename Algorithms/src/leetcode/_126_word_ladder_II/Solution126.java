package leetcode._126_word_ladder_II;

import java.util.*;


public class Solution126 {
    private Map<String, List<String>> vertexNeighborsMap;
    private List<List<String>> words;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        words = new ArrayList<>();
        if(wordList.size() == 0)
            return words;

        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        vertexNeighborsMap = new HashMap<>();
        Map<String, Integer> ladder = new HashMap<>();

        for(String string : wordList)
            ladder.put(string, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);

        wordList.add(endWord);
        while (!queue.isEmpty()){
            String word = queue.poll();
            // step denotes how many steps needed to travel one word
            int step = ladder.get(word)+1;
            if(step > min)
                break;
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char c = 'a'; c <= 'z'; c++){
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if(ladder.containsKey(newWord)){
                        if(step > ladder.get(newWord)){
                            continue;
                        }
                        else if(step < ladder.get(newWord)){
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        if(vertexNeighborsMap.containsKey(newWord))
                            vertexNeighborsMap.get(newWord).add(word);
                        else{
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            vertexNeighborsMap.put(newWord, list);
                        }
                        if(newWord.equals(endWord))
                            min = step;
                    }
                }
            }
        }

        LinkedList<String> result = new LinkedList<>();
        backTrace(endWord,beginWord, result);
        return words;
    }


    private void backTrace(String word, String start, List<String> list){
        if(word.equals(start)){
            list.add(0, start);
            words.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if(vertexNeighborsMap.get(word) != null){
            for(String s : vertexNeighborsMap.get(word))
                backTrace(s, start, list);
        }
        list.remove(0);
    }
}
