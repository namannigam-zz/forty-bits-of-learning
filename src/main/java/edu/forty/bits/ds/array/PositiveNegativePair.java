package edu.forty.bits.ds.array;

/**
 * @see <href>https://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0#ExpectOP</href>
 */
public class PositiveNegativePair {

    public static int[] positiveNegativePairs(int[] input) {
        int[] output = new int[input.length];
        int c = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j] * -1) {
                    output[c++] = input[i];
                    output[c++] = input[j];
                }
            }
        }
        return output;
    }
}