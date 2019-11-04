package edu.forty.bits.ps.competitive.anzen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HighestAverageUsingSortedList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] set = java.util.stream.IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
        Arrays.sort(set);

        int Q = scanner.nextInt();

        for(int j = 0; j < Q; j++) {
            int K = scanner.nextInt();
            List<Integer> list =
                    java.util.stream.IntStream.of(set).boxed().collect(java.util.stream.Collectors.toList());
            if (list.get(0) >= K) {
                System.out.println(0);
            } else {
                while (!list.isEmpty()) {
                    if (K > averageOfSet(list)) {
                        System.out.println(list.size());
                        break;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }

    private static int averageOfSet(List<Integer> list) {
        int sum = list.stream().mapToInt(i -> i).sum();
        return sum / list.size();
    }
}