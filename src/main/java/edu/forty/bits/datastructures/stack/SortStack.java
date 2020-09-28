package edu.forty.bits.datastructures.stack;

import java.util.Stack;

/**
 * Write a program to sort stack to keep the smallest element at the top.
 * You can use additional temporary stack but may not copy elements into any other data structure.
 * Operations to be supported - push, pop, peek, isEmpty
 */
public class SortStack {

    // one way to implement this could have been using two stacks and keeping a minimum value same as
    // the Min operations
    // another is to have two stacks and keep one as sorted based on operations with another
    void sort(Stack<Integer> stack) {
        Stack<Integer> another = new Stack<>();
        while (!stack.isEmpty()) {
            // insert elements in sorted order to the new stack
            int tmp = stack.pop();
            while (!another.isEmpty() && another.peek() > tmp) {
                stack.push(another.pop());
            }
            another.push(tmp);
        }
        while (!another.isEmpty()) {
            stack.push(another.pop()); // copy elements back to the original stack
        }
    }
}