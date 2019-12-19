package edu.forty.bits.datastructures.stack;

import java.util.EmptyStackException;

// describe how to implement 3 stacks using an array
// if the size fo each stack is defined we can create an array according to it and distribute
// elements
public class FixedMultiStack {

    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    // in our example the number of stacks is fixed to 3, but it could also be varied for fixed size
    // multi stacks
    public FixedMultiStack(int stackCapacity, int numberOfStacks) {
        this.stackCapacity = stackCapacity;
        values = new int[stackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    void push(int stackNumber, int value) throws StackOverflowError {
        if (isFull(stackNumber)) {
            throw new StackOverflowError("Custom exception possibly.");
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)] = value;
    }

    int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNumber);
        int value = values[topIndex];
        values[topIndex] = 0; // clear (ask if the stacks could have negative numbers as well
        sizes[stackNumber]--; // shrink
        return value;
    }

    int peek(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNumber)];
    }

    private boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    // index of top is currently being used for both push and pop
    // one should ensure the index returned by this method are used consistently (do check)
    private int indexOfTop(int stackNumber) {
        int offSet = stackNumber * stackCapacity;
        int size = sizes[stackNumber];
        return offSet + size - 1;
    }

    private boolean isFull(int stackNumber) {
        return sizes[stackNumber] == stackCapacity;
    }
}
