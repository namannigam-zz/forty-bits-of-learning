package edu.forty.bits.ps.competitive.uber;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenSubArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        List<Integer> numbers =
                IntStream.range(0, N).mapToObj(i -> scanner.nextInt()).collect(Collectors.toList());
        int K = scanner.nextInt(); // max odd elements allowed in subArray
        int result2 = countSubArrays(numbers, K);
        System.out.println(result2);
    }

    private static int countSubArrays(List<Integer> items, int m) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            for (int j = i; j < items.size(); j++) {
                if (validSubArray(items.subList(i, j + 1), m)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean validSubArray(List<Integer> coll, int m) {
        return coll.stream().filter(a -> a % 2 != 0).count() <= m;
    }
}
