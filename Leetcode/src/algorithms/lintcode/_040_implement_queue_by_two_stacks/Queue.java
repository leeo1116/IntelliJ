package algorithms.lintcode._040_implement_queue_by_two_stacks;

import java.util.Stack;

/**
 * Created by Charlie on 2017/2/11. Cloudy to Sunny
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int topElement = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return topElement;
    }

    public int top() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int topElement = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return topElement;
    }
}
