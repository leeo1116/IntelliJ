package algorithms.leetcode._282_expression_add_operations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 2016/7/17.
 */
public class Solution282 {
    public List<String> addOperatioins(String num, int target){
        List<String> exps = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFS(exps, sb, num, 0, target, 0, 0);
        return exps;
    }

    public void DFS(List<String> exps, StringBuilder sb, String num, int pos, int target, long eval, long multi){
        if(pos == num.length()){
            if(target == eval)
                exps.add(sb.toString());
                return;
        }

        for(int i = pos; i < num.length(); i++){
            if(num.charAt(pos) == '0' && i != pos)
                break;
            long curNum = Long.parseLong(num.substring(pos, i+1));
            int len = sb.length();
            if(pos == 0){
                DFS(exps, sb.append(curNum), num, i+1, target, curNum, curNum);
                sb.setLength(len);
            }
            else{
                DFS(exps, sb.append('+').append(curNum), num, i+1, target, eval+curNum, curNum);
                sb.setLength(len);
                DFS(exps, sb.append('-').append(curNum), num, i+1, target, eval-curNum, -curNum);
                sb.setLength(len);
                DFS(exps, sb.append('*').append(curNum), num, i+1, target, eval-multi+multi*curNum, multi*curNum);
                sb.setLength(len);
            }
        }
    }
}
