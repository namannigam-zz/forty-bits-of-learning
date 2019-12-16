package edu.forty.bits.ds.string;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique character. What if you cannot use
 * any additional data structures.
 */
public class UniqueCharacters {

    boolean isUnique(String str) {
        // number of characters possible with extended ASCII :: max of O(c,n) extra space
        boolean[] hash = new boolean[256];

        // O(n) for string length of 'n' characters
        // arguably can be termed as O(1) for maximum of character counts e.g. 128
        for (char ch : str.toCharArray()) {
            if (hash[ch]) return false; // duplicate character
            else hash[ch] = true;
        }
        return true;
    }

    // If one can assume the characters to be only varying from 'a' to 'z', there is a possible space
    // reduction using bit representation for these characters.
    boolean uniqueAlphabets(String str) {
        // An integer to store presence/absence of 26 characters by using its 32 bit representation.
        int checker = 0; // O(1) space

        for (char ch : str.toCharArray()) { // O(n)
            int val = (ch - 'a');
            // Duplicate character, if a bit corresponding to current character is already set
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                checker |= (1 << val); // set bit otherwise
            }
        }
        return true;
    }

    /*
     * Complexity of toCharArray is O(n) where n is the length of the string.
     * @see https://stackoverflow.com/questions/14062867/what-is-the-run-time-of-string-tochararray
     *
     * While iterating through a string using charAt(i) is more efficient than toCharArray.
     * Readability and JIT compiler optimisation are the clauses to consider.
     */

    // Without using any additional data structure
    boolean isUniqueWithoutDS(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // alternatively one can sort the character array first and then compare adjacent elements.
    boolean isUniqueWithoutDSOptimised(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // time complexity of O(n log(n)) for n characters in the string
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}