package edu.forty.bits.problemsolving.competitive.hackerearth.easy.september18;

import java.util.*;
import java.util.stream.IntStream;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arrayOfInt = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();

        int minCost = 0;
        Arrays.sort(arrayOfInt);
        int largestElem = arrayOfInt[arrayOfInt.length - 1];
        if (n > largestElem) {
            minCost = minCost + ((n - largestElem) * x);
        }

        Map<Integer, Integer> valueToCountMap = new HashMap<>();
    }

    public static boolean distinctValues(int[] arr) {
        return IntStream.range(0, arr.length - 1)
                .noneMatch(i -> IntStream.range(i + 1, arr.length).anyMatch(j -> arr[i] == arr[j]));
    }

    public static long pow(long a, long n, long mod) {
        long ret = 1;
        int x = 63 - Long.numberOfLeadingZeros(n);
        for (; x >= 0; x--) {
            ret = ret * ret % mod;
            if (n << 63 - x < 0) ret = ret * a % mod;
        }
        return ret;
    }

    public static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }

    private static int finalLeastFrequentLargestElement(Map<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> some = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> frequency = Map.Entry.comparingByKey();
        Comparator<Map.Entry<Integer, Integer>> value =
                Collections.reverseOrder(Map.Entry.comparingByValue());
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }

    private static int finalMostFrequentSmallestElement(Map<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> some = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> frequency =
                Collections.reverseOrder(Map.Entry.comparingByKey());
        Comparator<Map.Entry<Integer, Integer>> value = Map.Entry.comparingByValue();
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }
}
