package github.main;

import github.algorithms._207_course_schedule.Solution;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int courses = 10;
        int [][]pres = {{1, 2}, {3, 5}, {2, 0}, {2, 8}};
        Solution s = new Solution();
        System.out.print(s.canFinish(courses, pres));
    }

}
