package edu.forty.bits.problemsolving.competitive.expedia;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyBasedSort {

    private static void customSort(int[] arr) {
        List<Integer> input =
                Arrays.stream(arr).boxed().collect(Collectors.toList()); // converting to a list

        Map<Integer, Integer> map = new HashMap<>(); // to store the frequency of the values

        input.forEach(x -> map.merge(x, 1, (a, b) -> a + b)); // storing the frequencies of the numbers

        Map<Integer, Integer> sortedMap =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new)); // sorting based on the values/frequencies

        sortedMap.forEach(
                (key, value) -> {
                    for (int i = 0; i < value; i++) {
                        System.out.println(key);
                    }
                }); // printing out the keys based on their frequencies
    }
}
