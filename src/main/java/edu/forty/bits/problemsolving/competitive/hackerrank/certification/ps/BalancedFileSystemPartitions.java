package edu.forty.bits.problemsolving.competitive.hackerrank.certification.ps;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedFileSystemPartitions {

    static class Result {
        public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
            if (parent.size() != files_size.size()) {
                throw new RuntimeException("why!!??");
            }

            Map<Integer, Integer> indexToParent = IntStream.range(0, parent.size()).boxed()
                    .collect(Collectors.toMap(Function.identity(), parent::get));

            Map<Integer, Integer> indexToFileSize = IntStream.range(0, files_size.size()).boxed()
                    .collect(Collectors.toMap(Function.identity(), files_size::get));

            Map<Integer, List<Integer>> parentToIndexes = IntStream.range(0, parent.size()).boxed()
                    .collect(Collectors.groupingBy(parent::get));

            Map<Integer, Integer> effectiveSize = fileSizeCompute(parentToIndexes, indexToFileSize);

            int minDiff = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : indexToParent.entrySet()) {
                int leftWt = effectiveSize.getOrDefault(entry.getKey(), 0);
                int rightWt = effectiveSize.getOrDefault(entry.getValue(), 0) - leftWt;
                minDiff = Math.min(Math.abs(leftWt - rightWt), minDiff);
            }
            return minDiff;
        }

    }

    private static Map<Integer, Integer> fileSizeCompute(Map<Integer, List<Integer>> parentToIndexes,
                                                         Map<Integer, Integer> indexToFileSize) {
        Map<Integer, Integer> effectiveSize = new HashMap<>();
        LinkedHashMap<Integer, List<Integer>> sorted = parentToIndexes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        for (Map.Entry<Integer, List<Integer>> p : sorted.entrySet()) {
            for (Integer child : p.getValue()) {
                effectiveSize.merge(p.getKey(),
                        indexToFileSize.getOrDefault(child, 0), Integer::sum);
            }
        }
        return effectiveSize;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int parentCount = Integer.parseInt(scanner.next().trim());

        List<Integer> parent = IntStream.range(0, parentCount)
                .mapToObj(i -> scanner.next().replaceAll("\\s+$", ""))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int files_sizeCount = Integer.parseInt(scanner.next().trim());

        List<Integer> files_size = IntStream.range(0, files_sizeCount)
                .mapToObj(i -> scanner.next().replaceAll("\\s+$", ""))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = Result.mostBalancedPartition(parent, files_size);

        System.out.println(result);

        scanner.close();
    }
}