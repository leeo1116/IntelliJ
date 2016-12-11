package leetcode._316_remove_duplicate_letters;

/**
 * Created by Liang Li on 2016/7/16.
 */
public class Solution {
    public String removeDuplicateLetters(String s){
        int []count = new int[26];
        // position of smallest s[i]
        int pos = 0;
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i)-'a']++;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos))
                pos = i;
            if(--count[s.charAt(i)-'a'] == 0)
                break;
        }
        return s.length() == 0 ? "" : s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
    }
}
