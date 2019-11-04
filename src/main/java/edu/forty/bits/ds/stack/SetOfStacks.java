package edu.forty.bits.ds.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// stack of plates example, if previous stack exceeds threshold create a new stack,
// implement SetOfStacks where the push and pop behaves identical to single stack
// (follow up implementing popAt(int index) which performs pop operation no a specific sub-stack)
public class SetOfStacks {

  private int capacity;
  // custom implementation of stack for this
  private List<Stack> stacks = new ArrayList<>();

  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }

  // push would be identical but still do operations on the last stack only
  void push(int plate) {
    Stack last = getLastStack();
    if (last != null && !last.isFull()) { // for capacity check
      last.push(plate);
    } else { // create a new stack otherwise
      Stack plates = new Stack(capacity); // capacity could be specified
      plates.push(plate);
      stacks.add(plates);
    }
  }

  // pop would also work on the last stack of plates with a check for empty list of stacks and a
  // corner case for stack getting empty
  int pop() {
    Stack last = getLastStack();
    if (last == null) {
      throw new EmptyStackException();
    } else {
      int val = last.pop();
      if (last.size == 0) {
        stacks.remove(stacks.get(stacks.size() - 1));
      }
      return val;
    }
  }

  private Stack getLastStack() {
    if (stacks.size() == 0) return null;
    return stacks.get(stacks.size() - 1);
  }

  boolean isEmpty() {
    Stack last = getLastStack();
    return last == null || last.isEmpty();
  }

  // popAt would be an operation to perform pop
  int popAt(int index) {
    return leftShift(index, true);
  }

  // rollover strategy to balance the pop at the middle of any stack
  private int leftShift(int index, boolean removeTop) {
    Stack stack = stacks.get(index);
    int removedItem;
    if (removeTop) removedItem = stack.pop();
    else removedItem = stack.removeBottom();
    if (stack.isEmpty()) {
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return removedItem;
  }

  // stack implementation to keep the track of plates above and below one plate and perform
  // operations accordingly
  class Stack {
    public int size = 0;
    Node top, bottom;
    private int capacity;

    Stack(int capacity) {
      this.capacity = capacity;
    }

    boolean isFull() {
      return capacity == size;
    }

    void join(Node above, Node below) {
      if (below != null) below.above = above;
      if (above != null) above.below = below;
    }

    public boolean push(int v) {
      if (size == capacity) {
        return false;
      }
      size++;
      Node n = new Node(v); // create new node for the value
      if (size == 1) bottom = n; // only single element, update bottom
      join(n, top); // join with
      top = n; // make it the new top
      return true;
    }

    int pop() {
      Node t = top;
      top = top.below;
      size--;
      return t.val;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    int removeBottom() {
      Node b = bottom;
      bottom = bottom.above; // make this a new bottom
      if (bottom != null) {
        bottom.below = null;
      }
      size--;
      return b.val;
    }
  }

  class Node {
    int val;
    Node above, below;

    Node(int val) {
      this.val = val;
    }
  }
}
