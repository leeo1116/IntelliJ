package github.main;

import github.algorithms._207_course_schedule.Solution;
import github.algorithms._282_expression_add_operations.Solution282;

public class TestDriver {

    public static void main(String[] args) {
	    // write your code here
        int courses = 10;
        int [][]pres = {{1, 2}, {3, 5}, {2, 0}, {2, 8}};
        Solution s = new Solution();
        System.out.print(s.canFinish(courses, pres));
        Solution282 s282 = new Solution282();
        System.out.println(s282.addOperatioins("123", 6));
    }

}
