package edu.forty.bits.ps.competitive.hackerearth.easy.september18;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a3 = scanner.nextInt();
        int a4 =scanner.nextInt();

        int a2 = a4-a3;
        int a1 = a3-a2;

        System.out.println(a1 + " " + a4);

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

    private static List<Rectangle> align_rectangle(List<Rectangle> rectangles) {
        Comparator<Rectangle> lengthComparator = Comparator.comparing(Rectangle::getLength);
        Comparator<Rectangle> breadthComparator = Collections.reverseOrder(Comparator.comparing(Rectangle::getBreadth));
        rectangles.sort(lengthComparator.thenComparing(breadthComparator));
        return rectangles;
    }

    private static class Rectangle {
        int length;
        int breadth;

        Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        public int getLength() {
            return length;
        }

        int getBreadth() {
            return breadth;
        }
    }
}