package edu.forty.bits.ds.string;

/**
 * @link https://www.geeksforgeeks.competitive/check-string-substring-another/
 */
public class IsSubstring {

    // This solution is O(m*n) for iterating in a nested manner
    static int isSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // A loop to slide pat[] one by one
        for (int i = 0; i <= n - m; i++) {
            int j;

            // For current index i, check for pattern match
            for (j = 0; j < m; j++) {
                if (s2.charAt(i + j) != s1.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    // String.contains internally uses the indexOf in java which has a time complexity of O(m*n)
    // Given that it uses naive string matching algorithm.
    static boolean isSubstringUsingIndexOf(String big, String small) {
        return big.contains(small);
    }

}