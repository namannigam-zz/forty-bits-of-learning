package edu.forty.bits.problemsolving.competitive.hackerearth.easy.march19;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> input =
                IntStream.range(0, N).mapToObj(a -> scanner.nextInt()).collect(Collectors.toList());

        Map<Integer, Long> map = frequencyBasedSortedMap(input);
        int minOperation = Integer.MAX_VALUE;
        while (!map.isEmpty()) {
            int targetValue = map.entrySet().iterator().next().getKey();
            int opCost =
                    input.stream()
                            .mapToInt(integer -> Math.min(integer, Math.abs(integer - targetValue)))
                            .sum();
            minOperation = Math.min(minOperation, opCost);
            map.remove(targetValue);
        }
        System.out.println(minOperation);
    }

    private static Map<Integer, Long> frequencyBasedSortedMap(List<Integer> list) {
        Map<Integer, Long> freq =
                list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // return result
        return freq.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
    }
}
