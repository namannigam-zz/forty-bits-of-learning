package org.practice.learning.stack;

import java.util.Stack;

public class StackWithMin extends Stack<StackWithMin.NodeWithMin> {

    // you can keep a track of 'min' for every push and peek at O(1) cost
    // just that it would then consume O(n) space more
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    private int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE; // error value
        } else {
            return peek().min;
        }
    }

    // used to update min with every push to keep the track of min with every element insertion
    class NodeWithMin {
        public  int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
