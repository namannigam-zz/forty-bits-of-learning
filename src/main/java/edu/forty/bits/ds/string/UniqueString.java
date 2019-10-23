package org.practice.learning.string;

// find if a com.stackoverflow.nullpointer.string has all unique characters (what if you cannot use additional data structures?)
public class UniqueString {

    public static boolean isUnique(String str) {
        boolean[] hash = new boolean[128]; // number of characters possible   max of O(c,n) extra space
        for (int i = 0; i < str.length(); i++) { // O(n) for com.stackoverflow.nullpointer.string length of arguably can be termed as O(1) for maximum of character counts e.g. 128
            if (hash[str.charAt(i)]) {
                return false;
            } else {
                hash[str.charAt(i)] = true;
            }
        }
        return true;
    }

    // assuming alphabets from 'a' to 'z' only
    public static boolean areChractersUnique(String str) {
        // An integer to store presence/absence
        // of 26 characters using its 32 bits.
        int checker = 0; // O(1) space

        for (int i = 0; i < str.length(); ++i) {  // O(n)
            int val = (str.charAt(i) - 'a');
            // If bit corresponding to current
            // character is already set
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            // set bit in checker
            checker |= (1 << val);
        }

        return true;
    }
}