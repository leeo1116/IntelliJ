package leetcode._297_serialize_and_deserialize_binary_tree;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Charlie on 2016/7/10.
 */
public class Codec {
    private static final String spliter = ",";
    private static final String nullNode = "x";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }


    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(nullNode).append(spliter);
        }
        else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }


    public TreeNode deserialize(String data){
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }


    private TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals(nullNode))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
