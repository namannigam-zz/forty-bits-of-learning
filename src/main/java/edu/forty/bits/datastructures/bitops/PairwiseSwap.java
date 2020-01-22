package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

/**
 * Write a program to swap odd and even bits in a integer with as few instructions as possible (e.g. bit 8 and bit 1
 * are swapped, bit 2 and bit 3 are swapped and so on.)
 */
@BitOps
public class PairwiseSwap {

    // we can mask the actual number with alternate sequence of 0 and 1 and then perform a logical right shift
    public static int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        int a = 234321;
        System.out.println(a + ": " + Integer.toBinaryString(a));
        int b = swapOddEvenBits(a);
        System.out.println(b + ": " + Integer.toBinaryString(b));
    }
}