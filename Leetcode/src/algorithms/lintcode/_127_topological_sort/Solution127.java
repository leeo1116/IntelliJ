package algorithms.lintcode._127_topological_sort;

import algorithms.lintcode.common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Charlie on 2016/10/31. Saturday
 */
public class Solution127 {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> nodeIndegreeMap = new HashMap<DirectedGraphNode, Integer>();
        // Calculate in-degree for all nodes
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                nodeIndegreeMap.put(neighbor, nodeIndegreeMap.getOrDefault(neighbor, -1)+1);
            }
        }
        // Enqueue nodes that have 0 indegree
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!nodeIndegreeMap.containsKey(node)) {
                queue.offer(node);
                nodes.add(node);
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                nodeIndegreeMap.put(neighbor, nodeIndegreeMap.get(neighbor)-1);
                if (nodeIndegreeMap.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    nodes.add(neighbor);
                }
            }
        }
    return nodes;
    }
}
