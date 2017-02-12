package algorithms.lintcode._132_word_search_II;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 2017/2/11. Sunny
 */
public class Solution132 {
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> wordsFound = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsSearch(board, i, j, root, wordsFound);
            }
        }
        return wordsFound;
    }

    private void dfsSearch(char[][] board, int i, int j, TrieNode p, List<String> wordsFound) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            wordsFound.add(p.word);
            p.word = null;  // handling duplication
        }
        board[i][j] = '#';
        if (i > 0) dfsSearch(board, i-1, j, p, wordsFound);
        if (j > 0) dfsSearch(board, i, j-1, p, wordsFound);
        if (i < board.length - 1) dfsSearch(board, i + 1, j, p, wordsFound);
        if (j < board[0].length - 1) dfsSearch(board, i, j + 1, p, wordsFound);
        board[i][j] = c;
    }

    private TrieNode buildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
