package edu.forty.bits.ds.string;

// replace all spaces in a string with %20, given the sufficient space
// and exact length of the string
// (in java use char[] to do it in place)
public class URLify {

  // the reason to use character array is that the strings are immutable
  private static String URLify(char[] str, int exactLength) {
    // count the number of spaces, determine the extra characters required and expected
    // string length
    int spaces = BasicStringUtility.spacesInString(str, exactLength);
    int index = exactLength + spaces * 2; // 2 extra characters for each replacement
    if (exactLength < str.length) str[exactLength] = '\0'; // end array in case of extra spaces
    // traverse in reverse order and replace characters while updating the index
    for (int i = exactLength; i >= 0 && index >= 0; i--) {
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
    return new String(str);
  }
}
