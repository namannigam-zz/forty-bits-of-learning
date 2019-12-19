package edu.forty.bits.datastructures.array;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You have accidentally removed all the spaces, punctuations, and capitalization in a lengthy document.
 * A sentence such as "I reset the computer. It still didn't boot!" became "iresetthecomputeritstilldidntboot".
 * You'll deal with the punctuation and capitalization later, right now you need to re-insert the spaces.
 * Most of the words are in the dictionary but few are not. Given a dictionary(a lis of strings) and the document
 * (a string), design an algorithm to un-concatenate the document ina way that minimises the number of
 * unrecognised characters.
 */
public class ReSpace {

    // The first step would be to find the character in order to place the first space,
    // then think of placing the second space and the third and so on
    private static String reSpace(Set<String> dictionary, String document) {
        ParseResult parseResult = split(dictionary, document, 0);
        return parseResult == null ? null : parseResult.parsed;
    }

    // time complexity of this turns out to be of O(2^n) at runtime
    private static ParseResult split(Set<String> dictionary, String document, int start) {
        if (start > document.length()) return new ParseResult(0, "");
        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;
        while (index < document.length()) {
            char c = document.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if (invalid < bestInvalid) {
                // short circuiting to ensure only optimised path is taken into account
                ParseResult parseResult = split(dictionary, document, index + 1);
                if (invalid + parseResult.invalid < bestInvalid) {
                    bestInvalid = invalid + parseResult.invalid;
                    bestParsing = partial + " " + parseResult.parsed;
                    if (bestInvalid == 0) break; // can't do better than this
                }
            }
            index++;
        }
        return new ParseResult(bestInvalid, bestParsing);
    }

    // Commonly, exponential runtime are optimised using memoization.
    // In order to use that, we need to find the sub-problem.
    private static String bestSplit(Set<String> dictionary, String sentence) {
        ParseResult[] memo = new ParseResult[sentence.length()];
        ParseResult r = split(dictionary, sentence, 0, memo);
        return r == null ? null : r.parsed;
    }

    // The complexity of this is derived by analysing, how many times would the split be called
    // For split(i), the methods split(i+1), split(i+2) would already have been called.
    // They would return immediately. Doing n-i calls at O(1), each takes o(n-i) time.
    // This means that split(i) takes O(i) time at most. Similar approach implies on split(i-1), split(i-2)
    // So if we make 1 call to split(n-1), 2 to split(n-2), we end up making the sum of 1 to n calls overall
    // Hence the time complexity of the solution sums to O(n^2) overall
    private static ParseResult split(Set<String> dictionary, String sentence, int start, ParseResult[] memo) {
        if (start >= sentence.length()) {
            return new ParseResult(0, "");
        }
        if (memo[start] != null) {
            return memo[start];
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;

        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 :
                    partial.length();
            if (invalid < bestInvalid) { // Short circuit
                /* Recurse, putting a space after this character. If this
                 * is better than the current best option, replace the best
                 * option. */
                ParseResult result = split(dictionary, sentence, index + 1, memo);
                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) break; // Short circuit
                }
            }

            index++;
        }
        memo[start] = new ParseResult(bestInvalid, bestParsing);
        return memo[start];
    }

    private static String clean(String str) {
        char[] punctuation = {',', '"', '!', '.', '\'', '?', ','};
        for (char c : punctuation) {
            str = str.replace(c, ' ');
        }
        return str.replace(" ", "").toLowerCase();
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>(Arrays.asList("", ""));
        String sentence = "As one of the top companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone.";
        sentence = clean(sentence);
        System.out.println(sentence);
        System.out.println(bestSplit(dictionary, sentence));
    }

    @AllArgsConstructor
    static class ParseResult {
        int invalid;
        String parsed;

        public static ParseResult min(ParseResult r1, ParseResult r2) {
            if (r1 == null) {
                return r2;
            }
            if (r2 == null) {
                return r1;
            }

            return r2.invalid < r1.invalid ? r2 : r1;
        }
    }
}