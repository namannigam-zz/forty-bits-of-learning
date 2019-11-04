package edu.forty.bits.ps.competitive.expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissinWordsAfterTruncation {

  static String[] missingWords(String s, String t) {
    List<String> inputWords = Arrays.stream(s.split(" ")).collect(Collectors.toList());
    List<String> truncatedWords = Arrays.stream(t.split(" ")).collect(Collectors.toList());
    List<String> outputWords = new ArrayList<>();
    inputWords.forEach(
        word -> {
          if (!truncatedWords.contains(word)) {
            outputWords.add(word);
          }
        });
    return outputWords.toArray(new String[0]);
  }
}
