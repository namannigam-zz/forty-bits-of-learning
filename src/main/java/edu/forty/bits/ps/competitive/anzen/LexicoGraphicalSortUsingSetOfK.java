package edu.forty.bits.ps.competitive.anzen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Alex has a com.stackoverflow.nullpointer.string S of length N consisting of lowercase alphabets. He wants to find lexicographically smallest
 * com.stackoverflow.nullpointer.string X of length N that can be formed using the following operation.
 * In one operation, he can select any one character among the at most first K characters of com.stackoverflow.nullpointer.string S, remove it from com.stackoverflow.nullpointer.string S and append it to com.stackoverflow.nullpointer.string X. He can apply this operation as many times as he wants.
 * Help Alex find the com.stackoverflow.nullpointer.string X.
 */
// TODO - optmise on time (2.0015 sec)
public class LexicoGraphicalSortUsingSetOfK {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        int N = inputString.length();
        int K = scanner.nextInt();

        // Contradictory statement "He can apply this operation as many times as he wants" Vs "Similarly after
        // applying the operation n times"


        if (N == K) {
            System.out.println(sortCharacters(inputString));
        } else {
            StringBuilder initialString = new StringBuilder(inputString);
            StringBuilder finalString = new StringBuilder();
            int i = 0;
            while (i < N - K) {
                char characterToBeRemoved = lexicographicallySmallestCharacter(initialString.substring(0, K));
                int indexofCharToBeRemoved = initialString.indexOf(String.valueOf(characterToBeRemoved));
                finalString.append(characterToBeRemoved);
                initialString.deleteCharAt(indexofCharToBeRemoved);
                i++;
            }
            System.out.println(finalString + sortCharacters(initialString.toString()));
        }
    }


    private static char lexicographicallySmallestCharacter(String input) {
        String temp = sortCharacters(input);
        return temp.charAt(0);
    }

    private static String sortCharacters(String lastThreeCharacters) {
        char[] characterList = lastThreeCharacters.toCharArray();
        Arrays.sort(characterList);
        return new String(characterList);
    }
}