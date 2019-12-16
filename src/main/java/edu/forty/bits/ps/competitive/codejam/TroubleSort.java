package edu.forty.bits.ps.competitive.codejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TroubleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        IntStream.rangeClosed(1, T)
                .forEach(
                        t -> {
                            Integer N = scanner.nextInt();
                            List<Integer> input =
                                    IntStream.rangeClosed(1, N)
                                            .mapToObj(n -> scanner.nextInt())
                                            .collect(Collectors.toList());
                            List<Integer> sortedList = new ArrayList<>(input);
                            Collections.sort(sortedList);
                            if (sortedList.equals(troubleSort(input))) {
                                System.out.println("Case #" + t + ": " + "OK");
                            } else {
                                System.out.println("Case #" + t + ": " + result(input));
                            }
                        });
    }

    private static String result(List<Integer> troubleSorted) {
        for (int i = 0; i < troubleSorted.size() - 1; i++) {
            if (troubleSorted.get(i) > troubleSorted.get(i + 1)) {
                return String.valueOf(i);
            }
        }
        return "IMPOSSIBLE";
    }

    private static List<Integer> troubleSort(List<Integer> input) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < input.size() - 2; i++) {
                if (input.get(i) > input.get(i + 2)) {
                    done = false;
                    Collections.swap(input, i, i + 2);
                }
            }
        }
        return input;
    }
}
