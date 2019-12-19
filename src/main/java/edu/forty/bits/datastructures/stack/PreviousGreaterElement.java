package edu.forty.bits.datastructures.stack;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 10, 6, 12, 9, 11, 4, 5, 6, 3};
        printPrevGreater(arr, arr.length);
    }

    // Prints smaller elements on left side of every element
    private static void printPrevGreater(int[] arr, int n) {
        // Create an empty stack
        Stack<Integer> stack = new Stack<>();

        // Traverse all array elements
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top
            // element is smaller than or equal to arr[i]
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If all elements in S were greater than arr[i]
            if (stack.empty()) {
                System.out.print("-1, ");
            } else {
                System.out.print(stack.peek() + ", ");
            }

            // Push this element
            stack.push(arr[i]);
        }
    }
}
