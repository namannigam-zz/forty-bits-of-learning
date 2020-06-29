package edu.forty.bits.problemsolving.competitive.hackerrank.hackinterview;

import java.util.Scanner;
import java.util.stream.IntStream;

public class XORProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        IntStream.range(0, t).forEach(tItr -> {
            String s = scanner.next();
            int k = scanner.nextInt();
            String y = maxXorValue(s, k);
            System.out.println(y);
        });
    }

    public static String maxXorValue(String x, int k) {
        StringBuilder res = new StringBuilder();
        for (char ch : x.toCharArray()) {
            if (ch == '0' && k > 0) {
                res.append("1");
                k--;
            } else {
                res.append('0');
            }
        }
        return res.toString();
    }
}
