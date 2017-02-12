package algorithms.lintcode._107_word_break;

import java.util.Set;

/**
 * Created by Charlie on 2017/2/6. Snowy
 */
public class Solution107 {
    private int getMaxWordLength(Set<String> dict) {
        int maxLen = 0;
        for (String word : dict) {
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int strLen = s.length();
        if (s == null || strLen == 0)
            return true;
        int maxWordLen = getMaxWordLength(dict);
        boolean[] canSplit = new boolean[strLen + 1];
        canSplit[0] = true;
        for (int i = 1; i < strLen+1; i++) {
            canSplit[i] = false;
            for (int j = 1; j < maxWordLen+1 && j < i+1; j++) {
                if (canSplit[i-j] && dict.contains(s.substring(i-j, i))) {
                    canSplit[i] = true;
                    break;
                }
            }
        }
        return canSplit[strLen];
    }
}
