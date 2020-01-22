package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

/**
 * Write a method that finds the maximum of two numbers. You should not use if-else orr any other comparison operator.
 */
@BitOps
public class NumberMax {

    // Math.max
    int maxWithoutBranch(int a, int b) {
        return Math.max(a, b); //uses ternary operator
    }

    // another way is to compare bits starting form most significant bit (would have to consider the sign bit here)
    // one would end up using if else fo negative vs positive number behaviour in such a scenario

    /* Flips a 1 to a 0 and a 0 to a 1 */
    public static int flip(int bit) {
        return 1 ^ bit;
    }

    /* Returns 1 if a is positive, and 0 if a is negative */
    public static int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }

    // but the problem with above approach is the overflow when performing (INT.MAX-2 -15)
    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a); // if a >= 0, then 1 else 0
        int sb = sign(b); // if b >= 0, then 1 else 0
        int sc = sign(c); // depends on whether or not a - b overflows

        /* We want to define a value k which is 1 if a > b and 0 if a < b.
         * (if a = b, it doesn't matter what value k is) */

        int useSignOfA = sa ^ sb; // If a and b have different signs, then k = sign(a)
        int useSignOfC = flip(sa ^ sb); // If a and b have the same sign, then k = sign(a - b)

        /* We can't use a comparison operator, but we can multiply values by 1 or 0 */
        int k = useSignOfA * sa + useSignOfC * sc;
        int q = flip(k); // opposite of k
        return a * k + b * q;
    }

    public static void main(String[] args) {
        int a = 26;
        int b = -15;

        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

        a = -15;
        b = 2147483647;

        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
    }
}