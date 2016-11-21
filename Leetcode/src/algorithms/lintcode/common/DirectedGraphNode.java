package algorithms.lintcode.common;

import java.util.ArrayList;

/**
 * Created by Charlie on 2016/10/31. Monday
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>();}
}
