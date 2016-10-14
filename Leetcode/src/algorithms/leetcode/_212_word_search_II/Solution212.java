package algorithms.leetcode._212_word_search_II;

import java.util.ArrayList;
import java.util.List;


public class Solution212 {
    public List<String> findWords(char [][]board, String []words){
        List<String> wordsFound = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++)
                DFS(board, i, j, root, wordsFound);
        }
        return wordsFound;
    }


    private void DFS(char [][]board, int i, int j, TrieNode p, List<String> wordsFound){
        char c = board[i][j];
        if(c == '#' || p.children[c-'a'] == null)
            return;
        p = p.children[c-'a'];
        // found one valid word
        if(p.word != null){
            wordsFound.add(p.word);
            // to avoid duplicate
            p.word = null;
        }

        board[i][j] = '#';
        if(i > 0)
            DFS(board, i-1, j, p, wordsFound);
        if(j > 0)
            DFS(board, i, j-1, p, wordsFound);
        if(i < board.length-1)
            DFS(board, i+1, j, p, wordsFound);
        if(j < board[0].length-1)
            DFS(board, i, j+1, p, wordsFound);
        board[i][j] = c;
    }


    private TrieNode buildTrie(String []words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode p = root;
            for(char c : w.toCharArray()){
                int i = c-'a';
                if(p.children[i] == null)
                    p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.word = w;
        }
        return root;
    }


    private class TrieNode{
        TrieNode []children = new TrieNode[26];
        String word;
    }

}

