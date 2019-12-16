package edu.forty.bits.ps.competitive.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SMSSplitter {

    // at most 30 characters long
    // no word should be split in the middle
    // order of the chunk (k/n) - 6,7 or 8 chars
    // within 30 characters .. no ordering
    private static final int CHUNK_SIZE = 30;
    private static final int CHUNK_SIZE_WITH_ORDER = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        if (message.length() <= CHUNK_SIZE) {
            System.out.println(1);
        } else {
            //            int minChunks = message.length() / CHUNK_SIZE;
            List<String> words = Arrays.stream(message.split(" ")).collect(Collectors.toList());
            int count = 0;
            while (!words.isEmpty()) {
                words = chunkCreation(words);
                count++;
            }
            System.out.println(count);
        }
    }

    private static List<String> chunkCreation(List<String> words) {
        int charCount = 0;
        List<String> updatedWords = new ArrayList<>(words);
        String lastWordUsed = updatedWords.get(0);
        while (charCount < CHUNK_SIZE_WITH_ORDER && !updatedWords.isEmpty()) {
            lastWordUsed = updatedWords.get(0);
            charCount += updatedWords.remove(0).length() + 1;
        }
        if (charCount > CHUNK_SIZE_WITH_ORDER) {
            updatedWords.add(0, lastWordUsed);
        }
        return updatedWords;
    }
}
