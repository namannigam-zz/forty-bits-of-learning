package org.practice.learning.competitive.rebelfoods;

import java.util.Scanner;

public class StringConversion {

    /**
     * "Alfred" Rebel's cute but innovative personal butler bot, decides to play a game to give us some relief from being too awesome in our day to day operations. He would be giving us two strings and would ask us to make them identical, using the minimum actions possible of the following types:
     * <p>
     * Select any character in any of the strings and repeat it (add another instance of this character exactly after it). For example, in a single move "abc" could be changed to "abbc" (by repeating the character 'b').
     * Select any two adjacent and identical characters in any of the strings, and delete one of them.
     * For example, in a single move, "abbc" could be changed to "abc" (delete one of the 'b' characters), but can't convert it to "bbc".
     * The  actions are independent i.e. it's not necessary that an act of the first type should be followed by an action of the second type (or vice versa).
     * We decided to beat Alfred by writing a program to find if it is possible to make the given strings identical and to find the minimum number of moves if it is possible or print "Not possible" if the solution is not possible to derive.
     * <p>
     * Write a function:
     * <p>
     * function solution (com.stackoverflow.nullpointer.string A, com.stackoverflow.nullpointer.string B) {} that given 2 strings A and B, returns the minimum no. of tasks required to do so and "Not possible" if the solution is not possible to derive.
     * <p>
     * Input Format
     * Input would be the 2 strings in consideration one in each line. Each com.stackoverflow.nullpointer.string is non-empty and will consist of lower case English characters only, from 'a' to 'z'.
     * <p>
     * Output Format
     * If the two strings could be made identical print the minimum no. of tasks required to do so and "Not possible" if the solution is not possible to derive.
     **/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        int count = countConversionTask(str1, str2);
        System.out.println(count == -1 ? "Not possible" : count);
    }

    private static int countConversionTask(String str1, String str2) {
        if (str1.equals(str2)) return 0;
        String first = removeDuplicates(str1.toCharArray());
        String second = removeDuplicates(str2.toCharArray());
        return first.equals(second) ? Math.abs(str1.length() - str2.length()) : -1;
    }

    private static String removeDuplicates(char[] chars) {
        char prev = '\0';
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (prev != chars[i]) {
                chars[k++] = chars[i];
                prev = chars[i];
            }
        }
        return new String(chars).substring(0, k);
    }
}