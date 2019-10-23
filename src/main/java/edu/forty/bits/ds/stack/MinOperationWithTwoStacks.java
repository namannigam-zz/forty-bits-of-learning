package org.practice.learning.stack;

import java.util.Stack;

// design a stack with min operation such that all push, pop and min are O(1)
public class MinOperationWithTwoStacks extends Stack<Integer> {
    Stack<Integer> stack; // alternate stack used to store just the mins

    public MinOperationWithTwoStacks() {
        this.stack = new Stack<>();
    }

    public void pushValue(Integer value) {
        // push on alternate stack  if the value of min has changed
        if (value <= min()) {
            stack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int val = super.pop();
        if (val == min()) {
            stack.pop();
        }
        return val;
    }

    public int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE; // error handling
        } else {
            return stack.peek();
        }
    }
}