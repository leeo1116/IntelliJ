package github.algorithms._218_the_skyline_problem;

import java.util.*;

/**
 * Created by Charlie on 2016/7/18.
 */
public class Solution218 {
    public List<int []> getSkyline(int [][]buildings){
        List<int []> result = new ArrayList<>();
        List<int []> height = new ArrayList<>();

        // Represent each rectangle by top-left and top-right vertices
        for(int [] b : buildings){
            // top-left vertex is saved as negative number
            height.add(new int []{b[0], -b[2]});
            // top-right vertex is saved as positive number
            height.add(new int []{b[1], b[2]});
        }

        // Sort by horizontal coordinate, coordinate with equal horizontal but smaller height comes first
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])
                    return a[0]-b[0];
                else
                    return a[1]-b[1];
            }
        });

        // Build heap by height
        Queue<Integer> pq = new PriorityQueue<Integer>((a, b)->(b-a));
        // add ground line (0) to priority queue
        pq.offer(0);
        int pre_keypoint = 0;
        for(int []h : height){
            // add top-left vertex to heap
            if(h[1] < 0)
                pq.offer(-h[1]);
            else // remove the corresponding top-left vertex
                pq.remove(h[1]);
            int cur = pq.peek();
            if(pre_keypoint != cur){
                result.add(new int []{h[0], cur});
                pre_keypoint = cur;
            }
        }
        return result;
    }
}
