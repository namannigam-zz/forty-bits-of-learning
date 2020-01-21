package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

import java.util.ArrayList;
import java.util.List;

/**
 * You have an integer and you can flip exactly one bit from 0 to 1. Write code to find the length of longest sequence
 * of 1s you could create.
 */
@BitOps
public class FlipBitToWin {
    // Brute force: changing all 0s(eligible only if single occurrence) one at a time and
    // identifying the longest sequence of 1s
    // consider the max bit representation size as 32 bit
    public static final int SEQUENCE_LENGTH = 32;

    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    public static int longestSequence(int n) {
        int maxSeq = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            maxSeq = Math.max(maxSeq, longestSequenceOf1s(n, i));
        }
        return maxSeq;
    }

    public static int longestSequenceOf1s(int n, int indexToIgnore) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if (i == indexToIgnore || getBit(n, i)) {
                counter++;
                max = Math.max(counter, max);
            } else {
                counter = 0;
            }
        }
        return max;
    }

    // approach based on the alternating sequences
    public static int longestSequence2(int n) {
        if (n == -1) return Integer.BYTES * 8;
        List<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    /* Return a list of the sizes of the sequences. The sequence starts
     * off with the number of 0s (which might be 0) and then alternates
     * with the counts of each value.*/
    public static List<Integer> getAlternatingSequences(int n) {
        List<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);

        return sequences;
    }

    public static int findLongestSequence(List<Integer> seq) {
        int maxSeq = 1;

        for (int i = 0; i < seq.size(); i += 2) {
            int zerosSeq = seq.get(i);
            int onesSeqPrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;
            if (zerosSeq == 1) { // Can merge
                thisSeq = onesSeqNext + 1 + onesSeqPrev;
            } else if (zerosSeq > 1) { // Just add a one to either side
                thisSeq = 1 + Math.max(onesSeqPrev, onesSeqNext);
            } else if (zerosSeq == 0) { // No zero, but take either side
                thisSeq = Math.max(onesSeqPrev, onesSeqNext);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }

        return maxSeq;
    }


    /* Given set of three sequences ordered as {0s, then 1s, then 0s},
     * find max sequence that can be formed. */
    public static int getMaxSequence(int[] sequences) { /* 1s, then 0s, then [old] ones */
        if (sequences[1] == 1) { // a single 0 -> merge sequences
            return sequences[0] + sequences[2] + 1;
        } else if (sequences[1] == 0) { // no 0s -> take one side
            return Math.max(sequences[0], sequences[2]);
        } else {  // many 0s -> take side, add 1 (flip a bit)
            return Math.max(sequences[0], sequences[2]) + 1;
        }
    }

    public static void shift(int[] sequences) {
        sequences[2] = sequences[1];
        sequences[1] = sequences[0];
        sequences[0] = 0;
    }

    public static int longestSequence3(int n) {
        int searchingFor = 0;
        int[] sequences = {0, 0, 0}; // Counts of last 3 sequences
        int maxSequence = 1;

        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if ((n & 1) != searchingFor) {
                if (searchingFor == 1) { // End of 1s + 0s + 1s sequence
                    maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
                }

                searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
                shift(sequences); // Shift sequences
            }
            sequences[0]++;
            n >>>= 1;
        }

        /* Check final set of sequences */
        if (searchingFor == 0) {
            shift(sequences);
        }
        int finalSequence = getMaxSequence(sequences);
        maxSequence = Math.max(finalSequence, maxSequence);

        return maxSequence;
    }

    // logical shift operation performed here
    public static int flipBit(int a) {
        /* If all 1s, this is already the longest sequence. */
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // We can always have a sequence of at least one 1
        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else if ((a & 1) == 0) {
                /* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int original_number = Integer.MAX_VALUE;
        int new_number = longestSequence(original_number);
        System.out.println(Integer.toBinaryString(original_number));
        System.out.println(new_number);

        original_number = 1775;
        new_number = longestSequence2(original_number);
        System.out.println(Integer.toBinaryString(original_number));
        System.out.println(new_number);

        original_number = 20006;
        new_number = longestSequence3(original_number);
        System.out.println(Integer.toBinaryString(original_number));
        System.out.println(new_number);

        int[][] cases = {{-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, {1, 2}, {15, 5}, {1775, 8}};
        for (int[] c : cases) {
            int x = flipBit(c[0]);
            boolean r = (c[1] == x);
            System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
        }
    }
}