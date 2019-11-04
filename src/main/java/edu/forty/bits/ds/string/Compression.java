package edu.forty.bits.ds.string;

// compress a com.stackoverflow.nullpointer.string with representation such that aabcccccaa is
// represented as a2b1c5a2,
// but if the representation is not shorter then return the original
// com.stackoverflow.nullpointer.string
public class Compression {

  // the solution if O(n+k^2) since the n iterations require k (different character sequences)
  // concatenation
  private static String compressBad(String str) {
    // convert the complete com.stackoverflow.nullpointer.string using consecutive pointer and then
    // check the length with original
    String compressedString = "";
    int consecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      consecutive++;
      if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedString = compressedString + "" + str.charAt(i) + consecutive;
      }
    }
    return compressedString.length() < str.length() ? compressedString : str;
  }

  private static String compressOptimised(String str) {
    // convert the complete com.stackoverflow.nullpointer.string using consecutive pointer and then
    // check the length with original
    String compressedString;
    int consecutive = 0;
    StringBuilder compressedStringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      consecutive++;
      if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedStringBuilder
            .append(str.charAt(i))
            .append(consecutive); // reduces the concatenation overhead
        consecutive = 0;
      }
    }
    compressedString = compressedStringBuilder.toString();
    return compressedString.length() < str.length() ? compressedString : str;
  }

  private static String avoidCreatingAlternateString(String str) {
    // this splits up the task into two steps
    // 1. count the total characters of the compressed com.stackoverflow.nullpointer.string
    // 2. using com.stackoverflow.nullpointer.string builder create the
    // com.stackoverflow.nullpointer.string only if required
    int count = countCompressedCharacters(str);
    if (count >= str.length()) {
      return str;
    }
    int consecutive = 0;
    StringBuilder compressedStringBuilder =
        new StringBuilder(count); // initial capacity set avoids doubling of capacity every time
    for (int i = 0; i < str.length(); i++) {
      consecutive++;
      if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedStringBuilder
            .append(str.charAt(i))
            .append(consecutive); // reduces the concatenation overhead
        consecutive = 0;
      }
    }
    return compressedStringBuilder.toString();
  }

  private static int countCompressedCharacters(String str) {
    int compressedLength = 0;
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedLength +=
            1
                + String.valueOf(countConsecutive)
                    .length(); // notice the use of String.valueOf for double digit count ...
      }
    }
    return compressedLength;
  }
}
