package github.algorithms._210_course_schedule_II;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Each course can be denoted as a vertex in a graph. The prerequisites relationship between two classes can be described
     * by directed edge. If all courses can be finished, the length of topological sort of this graph will be equal to the
     * number of courses.
     * @param numCourses number of courses
     * @param prerequisites prerequisites 2D array in format {{v1, v2}, {v3, v4}, ..., {vi, vj}, ...}, list of edges
     * @return if the course schedule can be finished
     * @see com.sun.corba.se.impl.orbutil.graph.Graph
     */
    public int [] findOrder(int numCourses, int [][]prerequisites) {
        // Use 2D array as adjacency matrix to represent graph, i -> j
        int [][]matrix = new int[numCourses][numCourses];
        // Use an array to record the in-degrees
        int []indegrees = new int[numCourses];

        // Traverse the course prerequisites and convert the list of directed edges to adjacency matrix
        for(int i = 0; i < prerequisites.length; i++){
            // Get candidate course 0, 1, 2, ..., numCourse-1 which makes representing course by index possible
            int candidate = prerequisites[i][0];
            // Get prerequisite course of candidate
            int pre = prerequisites[i][1];
            // To avoid duplicate [candidate, pre] pairs, check if the corresponding connection exists
            if(matrix[pre][candidate] == 0){
                // Increase in-degrees of candidate
                indegrees[candidate]++;
            }
            // set pre -> candidate to 1, after the entire loop, the graph is represented by adjacency matrix
            matrix[pre][candidate] = 1;
        }

        // Use count to record the number of vertexes by topological sort
        int count = 0;
        // Use queue structure for BFS search
        Queue<Integer> queue = new LinkedList<>();
        // Traverse each vertex/course and add courses without any prerequisites(indegrees = 0) which are the start ver-
        // texes for topological sort
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        // Start BFS
        int[] courseOrder = new int[numCourses];
        while(!queue.isEmpty()){
            int course = queue.poll();
            courseOrder[count] = course;
            count ++;
            // Traverse neighbors of vertex course
            for(int i = 0; i < indegrees.length; i++){
                if(matrix[course][i] != 0){
                    // Mark next candidate course as visited by subtracting 1 to indegrees
                    indegrees[i] --;
                    // After subtracting if the indegrees is 0, there is not dependent of this candidate node, enqueue
                    if(indegrees[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses ? courseOrder : new int[0];
    }
}
