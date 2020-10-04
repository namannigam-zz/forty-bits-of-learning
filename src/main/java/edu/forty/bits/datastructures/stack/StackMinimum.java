package edu.forty.bits.datastructures.stack;

import java.util.Stack;

/**
 * How would you design a stack which, inn addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in O(1)
 */
public class StackMinimum {
    Stack<Integer> actual;
    Stack<Integer> stack; // alternate stack used to store just the min

    public StackMinimum() {
        this.stack = new Stack<>();
    }

    public void pushValue(Integer value) {
        // push on alternate stack  if the value of min has changed
        if (value <= min()) {
            stack.push(value);
        }
        actual.push(value);
    }

    public Integer pop() {
        int val = actual.pop();
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
