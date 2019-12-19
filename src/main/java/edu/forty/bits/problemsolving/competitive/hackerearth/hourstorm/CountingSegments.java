package edu.forty.bits.problemsolving.competitive.hackerearth.hourstorm;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountingSegments {
    public static final int MODULO = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Segment> segmentList =
                IntStream.range(0, N)
                        .mapToObj(a -> new Segment(scanner.nextLong(), scanner.nextLong()))
                        .collect(Collectors.toList());
        for (int i = 1; i <= N; i++) {
        }
    }

    boolean segmentContains(Segment one, Segment another) {
        return one.getL() <= another.getL() && one.getR() >= another.getR();
    }

    static class Segment {

        long l;
        long r;

        Segment(long l, long r) {
            this.l = l;
            this.r = r;
        }

        public long getL() {
            return l;
        }

        public long getR() {
            return r;
        }
    }
}
