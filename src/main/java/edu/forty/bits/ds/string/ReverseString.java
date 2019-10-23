package org.practice.learning.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString {

    public String[] reverseString(String[] input) {
        Arrays.asList(input).replaceAll(s -> new StringBuilder(s).reverse().toString());
        return input;
    }

    public static void reverseUsingByteArray() {
        String input = "GeeksforGeeks";

        // getBytes() method to convert com.stackoverflow.nullpointer.string into bytes[]
        byte[] strAsByteArray = input.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        // Store result in reverse order into the result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println(new String(result));
    }

    public static void reverseCollectionOfCharacter(char[] input) {
        List<Character> trial1 = new ArrayList<>();
        for (char c : input) {
            trial1.add(c);
        }
        Collections.reverse(trial1);
        trial1.forEach(System.out::print);
    }
}