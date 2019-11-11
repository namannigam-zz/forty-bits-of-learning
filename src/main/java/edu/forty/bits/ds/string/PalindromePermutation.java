package edu.forty.bits.ds.string;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. Palindrome is a
 * word that is same forwards and backwards. Permutation is a rearrangement of letters. The
 * palindrome does not need to be limited to just dictionary words.
 */
public class PalindromePermutation {

  // Do not think of generating all possible permutations of the string
  // and then check them for them being a palindrome!!

  // count the number of odd characters, should be exactly one
  public static boolean palindromePermutation(String string) {
    int[] chars = new int[128];
    // this is a O(n) approach with O(1) space
    for (char ch : string.toCharArray()) {
      chars[ch]++;
    }
    // count the odds should not be more than one as the string length could be odd as well
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

  // the runtime with a still remains O(n)
  // the optimisation helps to reduce iterating only once instead of twice
  public static boolean palindromePermutationOptimisation(String string) {
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
    // should be either 0 or 1
    return oddCount <= 1;
  }

  // another approach to achieve this is to make use of bit vector and ensure that
  // at last all bits are 0 or only 1 bit is set
}
