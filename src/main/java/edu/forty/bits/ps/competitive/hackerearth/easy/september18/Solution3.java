package edu.forty.bits.ps.competitive.hackerearth.easy.september18;

import java.util.*;
import java.util.stream.IntStream;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        List<Pair> pairs = new ArrayList<>();
        IntStream.range(0, n).map(i -> scanner.nextInt()).forEach(a -> {
            int d = scanner.nextInt();
            pairs.add(new Pair(a, d));
        });

        List<Integer> possibleValuesOfX = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int ops = scanner.nextInt();
            int id = scanner.nextInt();
            Pair pair = pairs.get(id - 1);

            int diff = pair.getA() - pair.getD();
            int sum = pair.getA() + pair.getD();

            if (ops == 1) {
                if (diff > 0) {
                    if (!possibleValuesOfX.contains(diff)) possibleValuesOfX.add(diff);
                }
                if (!possibleValuesOfX.contains(diff)) possibleValuesOfX.add(sum);
                Collections.sort(possibleValuesOfX);
                System.out.println(possibleValuesOfX.size());
                possibleValuesOfX.stream().map(aPossibleValuesOfX -> " " + aPossibleValuesOfX).forEach(System.out::print);
            }

            if (ops == 2) {
                if (diff > 0) {
                    if (possibleValuesOfX.contains(diff)) possibleValuesOfX.remove(diff);
                }
                if (possibleValuesOfX.contains(diff)) possibleValuesOfX.remove(sum);
                Collections.sort(possibleValuesOfX);
                System.out.println(possibleValuesOfX.size());
                possibleValuesOfX.stream().map(aPossibleValuesOfX -> " " + aPossibleValuesOfX).forEach(System.out::print);
            }

            if (ops == 3) {
                Collections.sort(possibleValuesOfX);
                System.out.println(possibleValuesOfX.size());
                possibleValuesOfX.stream().map(aPossibleValuesOfX -> " " + aPossibleValuesOfX).forEach(System.out::print);
            }
        }
    }

    static class Pair {
        int a;
        int d;

        Pair(int a, int d) {
            this.a = a;
            this.d = d;
        }

        public int getA() {
            return a;
        }

        public int getD() {
            return d;
        }

    }
}