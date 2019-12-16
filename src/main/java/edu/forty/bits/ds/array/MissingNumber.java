package edu.forty.bits.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An array A contains all the integers from 0 to N. Except for one number which is missing. In this
 * problem, we cannot access the entire integer in A with a single operation. The elements of A are
 * represented in binary, and the only operation we can use to access them is "fetchJthBitOfA[i]",
 * which takes constant time. Write code to find the missing integer. Can you do this in O(n) time?
 */
public class MissingNumber {
    private static int findMissing(List<BitInteger> array) {
        return findMissing(array, 0);
    }

    // But we could do better, we could make use of the given operation and
    // count the number of 0s and 1s in the LSB to identify if the missing number's LSB would be either 0 or 1
    // This can further process until there are no more numbers which can be involved in the computation

    private static int findMissing(List<BitInteger> array, int column) {
        if (column >= Integer.SIZE) {
            return 0;
        }
        List<BitInteger> oneBits = new ArrayList<>(array.size() / 2);
        List<BitInteger> zeroBits = new ArrayList<>(array.size() / 2);

        for (BitInteger integer : array) {
            if (integer.fetch(column) == 0) {
                zeroBits.add(integer);
            } else {
                oneBits.add(integer);
            }
        }

        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return (v << 1) | 0;
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }

    /* Create a random array of numbers from 0 to n, but skip 'missing' */
    private static List<BitInteger> initialize(int n, int missing) {
        BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
        List<BitInteger> array = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            array.add(new BitInteger(i == missing ? 0 : i));
        }

        // Shuffle the array once.
        for (int i = 0; i < n; i++) {
            int rand = i + (int) (Math.random() * (n - i));
            array.get(i).swapValues(array.get(rand));
        }

        return array;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(300000) + 1;
        int missing = rand.nextInt(n + 1);
        List<BitInteger> array = initialize(n, missing);
        System.out.println("The array contains all numbers but one from 0 to " + n + ", except for " + missing);

        int result = findMissing(array);
        if (result != missing) {
            System.out.println("Error in the algorithm!\n" + "The missing number is " + missing + ", but the algorithm reported " + result);
        } else {
            System.out.println("The missing number is " + result);
        }
    }

    // Integer representation is 8 bit (total number of bits would be defined by the value of N)
    // to calculate the length(N) in terms of umber of bits required to represent N it would require log(n) time
    // hence if the numbers were converted from binary to decimal, then summed to find the missing number,
    // the complexity would turn out to be O(n log(n))
    public int missingInteger(int[] arr) {
        return 0;
    }

    public static class BitInteger {
        static int INTEGER_SIZE;
        private boolean[] bits;

        public BitInteger() {
            bits = new boolean[INTEGER_SIZE];
        }

        /* Creates a number equal to given value. Takes time proportional
         * to INTEGER_SIZE. */
        BitInteger(int value) {
            bits = new boolean[INTEGER_SIZE];
            for (int j = 0; j < INTEGER_SIZE; j++) {
                if (((value >> j) & 1) == 1) bits[INTEGER_SIZE - 1 - j] = true;
                else bits[INTEGER_SIZE - 1 - j] = false;
            }
        }

        /**
         * Returns k-th most-significant bit.
         */
        public int fetch(int k) {
            if (bits[k]) return 1;
            else return 0;
        }

        /**
         * Sets k-th most-significant bit.
         */
        public void set(int k, int bitValue) {
            if (bitValue == 0) bits[k] = false;
            else bits[k] = true;
        }

        /**
         * Sets k-th most-significant bit.
         */
        public void set(int k, char bitValue) {
            if (bitValue == '0') bits[k] = false;
            else bits[k] = true;
        }

        /**
         * Sets k-th most-significant bit.
         */
        public void set(int k, boolean bitValue) {
            bits[k] = bitValue;
        }

        public void swapValues(BitInteger number) {
            for (int i = 0; i < INTEGER_SIZE; i++) {
                int temp = number.fetch(i);
                number.set(i, this.fetch(i));
                this.set(i, temp);
            }
        }

        public int toInt() {
            int number = 0;
            for (int j = INTEGER_SIZE - 1; j >= 0; j--) {
                number = number | fetch(j);
                if (j > 0) {
                    number = number << 1;
                }
            }
            return number;
        }
    }
}