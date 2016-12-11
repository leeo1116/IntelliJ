package lintcode._007_binary_tree_serialization;

import lintcode.common.ListNode;
import lintcode.common.TreeNode;

import java.util.*;

/**
 * Created by Charlie on 2016/10/26. Wednesday
 */
public class Solution007 {
    public String serialize(TreeNode root) {
        return formatString(serializeHelper(root));
    }

    public String formatString(List<String> inputStr) {
        String outputStr = "";
        if (inputStr.size() == 0) return "{"+outputStr+"}";
        int n = inputStr.size()-1;
        while (inputStr.get(n).equals("#"))
            n -= 1;
        for (int i = 0; i <= n; i++)
            if (i < n)
                outputStr += (inputStr.get(i)+",");
            else
                outputStr += inputStr.get(i);
        return "{"+outputStr+"}";
    }

    public List<String> serializeHelper(TreeNode root) {
        List<String> serialization = new ArrayList<String>();
        if (root == null) return serialization;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode peek = nodes.poll();
            if (peek != null) {
                serialization.add(Integer.toString(peek.val));
                nodes.add(peek.left);
                nodes.add(peek.right);
            } else {
                if (!nodes.isEmpty())
                    serialization.add("#");
            }
        }
        return serialization;
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 2) return null;
        data = data.substring(1, data.length()-1);
        String[] dataNew = data.split(",");
        return deserializeHelper(dataNew);
    }

    public TreeNode deserializeHelper(String[] data) {
        TreeNode root = null;
        if (data == null || data.length == 0) return root;
        if (data[0].equals("#"))
            return null;
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(new TreeNode(Integer.parseInt(data[0])));
        int index = 0;
        boolean isLeftNode = true;
        for (int i = 1; i < data.length; i++) {
            TreeNode node = null;
            if (!data[i].equals("#")) {
                node = new TreeNode(Integer.parseInt(data[i]));
                if (isLeftNode)
                    nodes.get(index).left = node;
                else
                    nodes.get(index).right = node;
                nodes.add(node);
            }
            if (!isLeftNode)
                index ++;
            isLeftNode = !isLeftNode;
        }
        return nodes.get(0);
    }
}
