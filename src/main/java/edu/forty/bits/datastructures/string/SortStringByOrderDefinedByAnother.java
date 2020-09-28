package edu.forty.bits.datastructures.string;

// @link https://www.geeksforgeeks.org/sort-string-according-order-defined-another-string/
public class SortStringByOrderDefinedByAnother {

    void sortByPattern(char[] str, char[] pat) {
        // Create a count array stor count of characters in str.
        int[] count = new int[128]; // assume ASCII

        // Count number of occurrences of each character in str.
        for (int i = 0; i < str.length; i++) {
            count[str[i] - 'a']++;
        }

        // Traverse the pattern and print every characters
        // same number of times as it appears in str. This
        // loop takes O(m + n) time where m is length of
        // pattern and n is length of str.
        int index = 0;
        for (char c : pat) {
            for (int j = 0; j < count[c - 'a']; j++) {
                str[index++] = c;
            }
        }
    }
}
