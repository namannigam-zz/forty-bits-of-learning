package edu.forty.bits.ps.competitive.hackerearth.easy.september18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.MAX_VALUE;
        int[] arrayOfInt = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
        long[] arrayOfLong = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
        double[] arrayOfDouble = IntStream.range(0, n).mapToDouble(i -> scanner.nextLong()).toArray();
        List<String> listOfString = IntStream.range(0, n).mapToObj(i -> scanner.next()).collect(Collectors.toList());

    }

    public static long pow(long a, long n, long mod) {
        long ret = 1;
        int x = 63 - Long.numberOfLeadingZeros(n);
        for (; x >= 0; x--) {
            ret = ret * ret % mod;
            if (n << 63 - x < 0)
                ret = ret * a % mod;
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
        Comparator<Map.Entry<Integer, Integer>> value = Collections.reverseOrder(Map.Entry.comparingByValue());
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }

    private static int finalMostFrequentSmallestElement(Map<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> some = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> frequency = Collections.reverseOrder(Map.Entry.comparingByKey());
        Comparator<Map.Entry<Integer, Integer>> value = Map.Entry.comparingByValue();
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }

}
