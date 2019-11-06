package edu.forty.bits.ds.string;

/**
 * @link
 *     https://www.geeksforgeeks.competitive/check-string-substring-another/
 */
public class IsSubstring {

  // This solution is O(m*n) for iterating ina nested manner
  public static int isSubstring(String s1, String s2) {
    int M = s1.length();
    int N = s2.length();

    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++) {
      int j;

      /* For current index i, check for
      pattern match */
      for (j = 0; j < M; j++) {
        if (s2.charAt(i + j) != s1.charAt(j)) {
          break;
        }
      }

      if (j == M) {
        return i;
      }
    }
    return -1;
  }
}
