package edu.forty.bits.datastructures.string;

/**
 * Implement a method to perform basic string compression using the counts of the repeated
 * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string
 * would not become smaller than the original string, your method should return the original string.
 * Assume: The string would comprise only of the uppercase and lowercase letters. (a-z)
 */
public class Compression {

    // one of the way is to create the resulting string first and
    // then comparing it with original to decide
    // the solution is O(n+k^2) since the n iterations require
    // k (different character sequences) concatenation
    String compressBad(String str) {
        // convert the complete string using consecutive pointer and
        // then check the length with original
        String compressedString = "";
        int consecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutive++;
            if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + consecutive;
                consecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    // Using the StringBuilder for such creation of a string is intuitive and
    // optimises the concatenation overhead of strings
    String compressOptimised(String str) {
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

    // another approach is to avoid creating a string if it would never be used (greater length)
    // this splits up the task into two steps
    // 1. count the total characters of the compressed string
    // 2. using string builder create the string only if required
    String avoidCreatingAlternateString(String str) {
        int count = countCompressedCharacters(str);
        if (count >= str.length()) {
            return str;
        }
        int consecutive = 0;
        // initial capacity set in StringBuilder avoids doubling of capacity every time
        StringBuilder compressedStringBuilder = new StringBuilder(count);
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

    private int countCompressedCharacters(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                // notice the use of String.valueOf().length for double digit count
            }
        }
        return compressedLength;
    }
}