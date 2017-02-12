package algorithms.lintcode._012_min_stack;

import java.util.Stack;

/**
 * Created by Charlie on 2017/2/11. Sunny
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty())
            minStack.push(number);
        else
            minStack.push(Math.min(number, minStack.peek()));
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
