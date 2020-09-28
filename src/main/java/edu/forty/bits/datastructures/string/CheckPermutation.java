package edu.forty.bits.datastructures.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {

    // assumes that the length check is already performed
    // this method performs the comparison in O(n) runtime where n is the length on the input string
    private static boolean countCharactersAndCompareString(String data, String input) {
        int[] chars = new int[128]; // ASCII assumption
        for (char ch : data.toCharArray()) {
            chars[ch]++;
        }
        for (char ch : input.toCharArray()) {
            chars[ch]--;
            if (chars[ch] < 0) return false;
        }
        return true;
    }

    // One way is to sort both the strings and compare them character by character, this would be O(n log(n))
    boolean isPermutation(String data, String input) {
        if (data.length() != input.length()) {
            return false;
        } else {
            return sortAndCompareStrings(data, input);
        }
    }

    private boolean sortAndCompareStrings(String data, String input) {
        String sortedData = sortString(data);
        String sortedInput = sortString(input);
        for (int i = 0; i < sortedData.length(); i++) { // O(n) to add to the existing complexity sequentially
            if (sortedData.charAt(i) != sortedInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean sortAndCompareStringUsingJavaStream(String data, String input) {
        String sortedData = sortString(data);
        String sortedInput = sortString(input);
        return IntStream.range(0, sortedData.length())
                .noneMatch(i -> sortedData.charAt(i) != sortedInput.charAt(i));
    }

    // This is a O(n log(n)) approach of sorting a string irrespective of any further conditions
    private String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /*
     * Another is to keep the character frequency of the characters in the first string and
     * compare it with the frequency of characters in the other string
     */

    private String sortStringUsingJavaStream(String str) {
        return str.chars()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    boolean isPermutationUsingCharacterCount(String data, String input) {
        if (data.length() != input.length()) {
            return false;
        } else {
            return countCharactersAndCompareString(data, input);
        }
    }

    boolean countCharacterAndCompareUsingJavaStream(String str1, String str2) {
        Map<Character, Long> characterFrequencyOfStr1 = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        Map<Character, Long> characterFrequencyOfStr2 = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return characterFrequencyOfStr1.entrySet().stream()
                .allMatch(e -> characterFrequencyOfStr2.getOrDefault(e.getKey(), 0L).equals(e.getValue()));
    }
}