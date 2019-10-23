package org.practice.learning.string;

// threed edits, delete, replace and insert a character, check if two strings are just one edit away
public class OneAway {

    public static boolean oneAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        if (first.length() == second.length() + 1) {
            return oneEditInsert(second, first); // same as delete, just a reversal of insert
        }
        return false;
    }

    private static boolean oneEditInsert(String first, String second) {
        int index1 = 0; // to maintain the pointer for shorter com.stackoverflow.nullpointer.string after mismatch
        int index2 = 0; // to maintain the pointer for longer com.stackoverflow.nullpointer.string after mismatch
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++; // create first mismatch for both the indexes
            } else {
                index1++;
                index2++;
            }

        }
        return true;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean oneReplaceAway = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (oneReplaceAway) {
                    return false;
                }
                oneReplaceAway = true;
            }
        }
        return true;
    }
}