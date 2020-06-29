package edu.forty.bits.problemsolving.competitive.hackerrank.certification.ps;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> query = IntStream.range(0, queryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(Collectors.toList());

        List<Integer> result = Result.stringAnagram(dictionary, query);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
            Map<Map<Character, Long>, Long> similarAnagramCount = dictionary.stream()
                    .collect(Collectors.toMap(Result::frequencyMap,
                            e -> 1L, Long::sum));
            return query.stream()
                    .map(Result::frequencyMap)
                    .map(t -> similarAnagramCount.getOrDefault(t, 0L).intValue())
                    .collect(Collectors.toList());
        }

        private static Map<Character, Long> frequencyMap(String charSequence) {
            return charSequence.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c,
                            Collectors.counting()));
        }

    }
}
