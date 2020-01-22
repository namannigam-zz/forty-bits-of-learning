package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

/**
 * Write a function to swap a number in place(that is without a temporary variables)
 */
@BitOps
public class NumberSwapper {

    // using no third variable, calculate the difference and proceed
    public static void swap(int a, int b) {
        // Example for a = 9, b = 4
        a = a - b; // a = 9 - 4 = 5
        b = a + b; // b = 5 + 4 = 9
        a = b - a; // a = 9 - 5
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    // Using XOR of values instead of subtraction
    public static void swapOpt(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void main(String[] args) {
        int a = 1672;
        int b = 9332;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        swap(a, b);
        swapOpt(a, b);
    }
}