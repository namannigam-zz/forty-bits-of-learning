package edu.forty.bits.ds.string;

// given a com.stackoverflow.nullpointer.string check if its a permutation of a palindrome
// (permutation might not be a dictionary word)
public class PalindromePermutation {

  public static boolean palindromePermutation(String string) {
    // count the number of odd characters, should be exactly one
    int[] chars = new int[128];
    // this is a O(n) approach with O(1) space
    for (char ch : string.toCharArray()) {
      chars[ch]++;
    }
    boolean oddCount = false;
    for (int ch : chars) {
      if (ch % 2 == 1) {
        if (oddCount) {
          return false;
        }
        oddCount = true;
      }
    }
    return true;
  }

  // the runtime still remains O(n), yet the optimisation helps to reduce iterating only once
  // instead of twice
  public static boolean palindromePermutationOptimisation(String string) {
    // count the number of odd characters, should be exactly one
    int oddCount = 0;
    int[] chars = new int[128]; // use basic utility of 'z'-'a'+1 to count array.
    // this is a O(n) approach with O(1) space
    for (char ch : string.toCharArray()) {
      chars[ch]++;
      if (chars[ch] % 2 == 1) {
        oddCount++;
      } else {
        oddCount--;
      }
    }

    return oddCount - 1 == 0;
  }

  // another approach to achieve this is to make use of bit vector and ensure that
  // at last all bits are 0 or only 1 bit is set
}
