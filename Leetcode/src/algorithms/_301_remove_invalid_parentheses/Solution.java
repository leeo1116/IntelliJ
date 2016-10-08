package algorithms._301_remove_invalid_parentheses;

import java.util.*;

/**
 * Created by Charlie on 2016/7/10.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s){
        List<String> validParenthses = new ArrayList<>();
        if(s == null)
            return validParenthses;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;
        while(!queue.isEmpty()){
            s = queue.poll();
            if(isValid(s)){
                validParenthses.add(s);
                found = true;
            }
            if(found)
                continue;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != '(' && s.charAt(i) != ')')
                    continue;
                String t = s.substring(0, i)+s.substring(i+1);
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return validParenthses;
    }

    boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                count++;
            if(c == ')') {
                if(count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }
}
