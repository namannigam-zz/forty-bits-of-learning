package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

/**
 * Write a function that adds two numbers. You should not use a + or any arithmetic operator.
 */
@BitOps
public class AddWithoutPlus {

    private static int addWithoutArithmeticOps(int x, int y) {
        // Iterate till there is no carry
        while (y != 0) {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    public static void main(String[] arg) {
        System.out.println(addWithoutArithmeticOps(15, 32));
        System.out.println(addWithoutArithmeticOps(44533, -932));
    }
}