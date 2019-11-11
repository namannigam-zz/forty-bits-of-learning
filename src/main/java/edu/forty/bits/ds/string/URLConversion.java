package edu.forty.bits.ds.string;

import java.util.stream.IntStream;

/**
 * Write a method ot replace all spaces inn a string with "%20". You may assume that
 * the string has sufficient space at the end to hold the characters, and that you are given the "true" length
 * of the string. (For in-place operations in Java use character array as strings are immutable.)
 */
public class URLConversion {

  char[] convertSpacesToUrl(char[] str, int trueLength) {
    // one traversal to count the spaces given the exact length of the string
    int spaces = spacesInString(str, trueLength);
    // determine the extra characters required (+2 for each space)
    int index = trueLength + spaces * 2;
    if (index < str.length) str[index] = '\0'; // end array in case of extra spaces
    // traverse in reverse order and replace characters while updating the index
    for (int i = trueLength; i >= 0 && index >= 0; i--) {
      if (str[i] == ' ') {
        str[index] = '0';
        str[index - 1] = '2';
        str[index - 2] = '%';
        index = index - 3;
      } else {
        str[index] = str[i];
        index--;
      }
    }
    return str;
  }

  private int spacesInString(char[] chars, int length) {
    return (int) IntStream.range(0, length).filter(i -> chars[i] == ' ').count();
  }

  int spacesInString(String str, int length) {
    return (int) str.chars().limit(length).filter(c -> c == (int) ' ').count();
  }
}