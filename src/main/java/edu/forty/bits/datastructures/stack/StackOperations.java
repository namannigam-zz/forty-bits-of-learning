package edu.forty.bits.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by naman.nigam on 03/10/16.
 */
public class StackOperations {

    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(in.nextLine().trim());
        Stack<Integer> permanent = new Stack<>();
        Stack<Integer> temporary = new Stack<>();

        for (int i = 0; i < numberOfOperations; i++) {
            switch (in.next().trim()) {
                case "push":
                    permanent.push(Integer.parseInt(in.next().trim()));
                    printTop(permanent);
                    break;
                case "pop":
                    permanent.pop();
                    if (permanent.empty()) System.out.println("EMPTY");
                    else printTop(permanent);
                    break;
                case "inc":
                    int x = Integer.parseInt(in.next().trim());
                    int d = Integer.parseInt(in.next().trim());
                    for (int j = 0; j < permanent.size() - x; j++) {
                        temporary.push(permanent.pop());
                    }
                    while (!permanent.empty()) {
                        temporary.push(permanent.pop() + d);
                    }
                    while (!temporary.empty()) {
                        permanent.push(temporary.pop());
                    }
                    printTop(permanent);
                    break;
                default:
                    System.out.println("Should have never been here!");
                    break;
            }
        }
    }

    private static void printTop(Stack<Integer> stack) {
        System.out.println(stack.peek());
    }
}
