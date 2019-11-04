package edu.forty.bits.ds.queue;

import java.util.Stack;

// implement a queue using two stacks
public class QueueUsingStack<T> {
    private Stack<T> stackNewest, stackOldest;

    public QueueUsingStack() {
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    // move elements from newest to oldest stack, to perform operations on stackOldest
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    // to optimise further, perform the shift of stacks only when the operation is required (lazily)

    public T peek() {
        shiftStacks(); // ensure stackOldest has the current elements
        return stackOldest.peek(); // retrieve the oldest item
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop(); // pop the oldest element

    }
}
