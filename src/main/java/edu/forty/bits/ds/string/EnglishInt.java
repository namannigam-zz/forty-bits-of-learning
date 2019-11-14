package edu.forty.bits.ds.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Given any integer, print an English phrase that describes the integer. e.g. "One Thousand, Two
 * Hundred Thirty Four"
 */
public class EnglishInt {

  // proper string mapping of all the cases is more required in such cases than the implementation
  // further categorisation of terms would matter on clarifying the question with the interviewer
  private static final String[] SMALLS = {
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
  };

  private static final String[] TENS = {
    "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  };

  private static final String[] HIGHER_DENOTION = {"", "Thousand", "Million", "Billion"};
  private static final String HUNDRED = "Hundred";
  private static final String NEGATIVE = "Negative";

  private String transformToEnglish(int num) {
    if (num == 0) {
      return SMALLS[0];
    } else if (num < 0) {
      return NEGATIVE + " " + transformToEnglish(Math.abs(num));
    }

    LinkedList<String> parts = new LinkedList<>();
    int chunkCount = 0;

    while (num > 0) {
      if (num % 1000 != 0) {
        String chunk = convertChunk(num % 1000) + " " + HIGHER_DENOTION[chunkCount];
        parts.addFirst(chunk);
      }
      num /= 1000; // shift chunk
      chunkCount++;
    }

    return listToString(parts);
  }

  /* Convert a linked list of strings to a string, dividing it up with spaces. */
  private static String listToString(List<String> parts) {
    return String.join(" ", parts);
  }

  private static String convertChunk(int number) {
    LinkedList<String> parts = new LinkedList<>();

    /* Convert hundreds place */
    if (number >= 100) {
      parts.addLast(SMALLS[number / 100]);
      parts.addLast(HUNDRED);
      number %= 100;
    }

    /* Convert tens place */
    if (number >= 10 && number <= 19) {
      parts.addLast(SMALLS[number]);
    } else if (number >= 20) {
      parts.addLast(TENS[number / 10]);
      number %= 10;
    }

    /* Convert ones place */
    if (number >= 1 && number <= 9) {
      parts.addLast(SMALLS[number]);
    }

    return listToString(parts);
  }
}