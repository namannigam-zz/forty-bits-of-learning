package org.practice.learning.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by naman.nigam on 03/10/16.
 */
public class StringFromCountedCharacter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(compress(input));
    }

    /**
     * Complete the function below.
     */
    private static String compress(String str) {

        Character character = str.charAt(0);
        Character[] characters = new Character[1024];
        characters[0] = character;
        IntStream.range(1, str.length()).forEach(i -> {
            if (character != str.charAt(i)) {
                characters[i] = character;
            }
        });
        return Arrays.toString(characters);
    }
}