package leetsCode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStackSolution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

class MinStack {
    private List<Integer> list;
    private List<Integer> mins;

    public MinStack() {
        list = new LinkedList();
        mins = new LinkedList();
    }

    public void push(int x) {
        list.add(x);

        if (mins.isEmpty())
            mins.add(x);
        else if (x < mins.get(mins.size() - 1))
            mins.add(x);
        else
            mins.add(mins.get(mins.size() - 1));
    }

    public void pop() {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
            mins.remove(mins.size() - 1);
        }
    }

    public int top() {
        if (!list.isEmpty()) {
            int top = list.get(list.size() - 1);

            return top;
        }

        return Integer.MAX_VALUE;
    }

    public int getMin() {
        return !mins.isEmpty()? mins.get(mins.size() - 1) : Integer.MAX_VALUE;
    }
}