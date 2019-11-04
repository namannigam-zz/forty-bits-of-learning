package edu.forty.bits.ds.string;

import java.util.stream.IntStream;

// determine if one com.stackoverflow.nullpointer.string is a permutation of another
public class CheckPermutation {

    // sort both the strings and compare character by character, this would be O(nlogn)
    public static boolean isPermutation(String data, String input) {
        if (data.length() != input.length()) {
            return false;
        } else {
            return sortAndCompareStrings(data, input);
        }
    }

    private static boolean sortAndCompareStrings(String data, String input) {
        String sortedData = BasicStringUtility.sortString(data);
        String sortedInput = BasicStringUtility.sortString(input);
        for (int i = 0; i < sortedData.length(); i++) { // O(n), but adjusted within O(nlogn) of sorting
            if (sortedData.charAt(i) != sortedInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // sort both the strings and compare character by character, this would be O(nlogn)
    public static boolean isPermutationUsingCharacterCount(String data, String input) {
        if (data.length() != input.length()) {
            return false;
        } else {
            return countCharactersAndCompareString(data, input);
        }
    }

    // assumes that the length check is already performed
    // this method performs the comparison in O(n) runtime where n is the length on the input com.stackoverflow.nullpointer.string
    private static boolean countCharactersAndCompareString(String data, String input) {
        int[] chars = new int[128]; //ASCII assumption
        for (char ch : data.toCharArray()) {
            chars[ch]++;
        }
        for (char ch : input.toCharArray()) {
            chars[ch]--;
            if (chars[ch] < 0) return false;
        }
        return true;
    }

    private static boolean sortAndCompareStringUsingStreams(String data, String input) {
        String sortedData = BasicStringUtility.sortString(data);
        String sortedInput = BasicStringUtility.sortString(input);
        return IntStream.range(0, sortedData.length())
                .noneMatch(i -> sortedData.charAt(i) != sortedInput.charAt(i));
    }
}