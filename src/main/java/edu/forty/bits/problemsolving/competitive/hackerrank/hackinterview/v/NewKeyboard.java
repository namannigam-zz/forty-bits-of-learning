package edu.forty.bits.problemsolving.competitive.hackerrank.hackinterview.v;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NewKeyboard {


    public static void main(String[] args) {
        System.out.println(receivedText("HE*<LL>O"));
        System.out.println(receivedText("ILOVE*<>*<*>4513#123UOJD<*>56OIUQERE"));
        System.out.println(receivedTextLL("HE*<LL>O"));
        System.out.println(receivedTextLL("ILOVE*<>*<*>4513#123UOJD<*>56OIUQERE"));
    }

    public static String receivedText(String emailText) {
        int currentIndex = 0;
        boolean ignoreNumerics = false;
        List<Character> result = new ArrayList<>();
        for (char ch : emailText.toCharArray()) {
            if (ch == '<') {
                currentIndex = 0;
            } else if (ch == '>') {
                currentIndex = result.size();
            } else if (ch == '#') {
                ignoreNumerics = !ignoreNumerics;
            } else if (ch == '*') {
                if (currentIndex != 0) {
                    result.remove(currentIndex - 1);
                    currentIndex--;
                }
            } else if (ch >= '0' && ch <= '9') {
                if (!ignoreNumerics) {
                    result.add(currentIndex, ch);
                    currentIndex++;
                }
            } else {
                result.add(currentIndex, ch);
                currentIndex++;
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // More performant than a List while adding and removing from an index
    public static String receivedTextLL(String emailText) {
        int currentIndex = 0;
        boolean ignoreNumerics = false;
        LinkedList<Character> result = new LinkedList<>();
        for (char ch : emailText.toCharArray()) {
            if (ch == '<') {
                currentIndex = 0;
            } else if (ch == '>') {
                currentIndex = result.size();
            } else if (ch == '#') {
                ignoreNumerics = !ignoreNumerics;
            } else if (ch == '*') {
                if (currentIndex != 0) {
                    result.remove(currentIndex - 1);
                    currentIndex--;
                }
            } else if (ch >= '0' && ch <= '9') {
                if (!ignoreNumerics) {
                    result.add(currentIndex, ch);
                    currentIndex++;
                }
            } else {
                result.add(currentIndex, ch);
                currentIndex++;
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }
}