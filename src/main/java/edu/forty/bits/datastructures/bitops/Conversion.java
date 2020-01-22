package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

import java.util.stream.IntStream;

/**
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 */
@BitOps
public class Conversion {
    // perform an XOR of A and B and count total number of set bits
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        int c = a ^ b;
        while (c != 0) {
            count += c & 1; // Increment count if c ends with a 1
            c >>>= 1; // Shift right by 1
        }
        return count;
    }

    public static int bitSwapRequiredAlt(int a, int b) {
        int count = 0;
        int c = a ^ b;

        System.out.println("****");
        System.out.println(c + ": " + Integer.toBinaryString(c));
        while (c != 0) {
            System.out.println("c - 1: " + c + ": " + Integer.toBinaryString(c - 1));
            c = c & (c - 1);
            System.out.println("c: " + c + ": " + Integer.toBinaryString(c));
            count++;
            System.out.println("****");
        }
        return count;
    }

    private static long bitSwapRequiredAltUsingStream(int a, int b) {
        return IntStream.iterate(a ^ b, c -> c != 0, c -> c & (c - 1)).count();
    }

    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ": " + Integer.toBinaryString(a));
        System.out.println(b + ": " + Integer.toBinaryString(b));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));
        System.out.println("Required number of bits: " + bitSwapRequiredAltUsingStream(a, b));
    }
}