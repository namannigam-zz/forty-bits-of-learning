package edu.forty.bits.problemsolving.competitive.hackerrank.hackinterview.v;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class JewelGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        IntStream.range(0, t).forEach(tItr -> {
            String s = scanner.next();
            int y = getMaxScore(s);
            System.out.println(y);
        });
    }

    public static int getMaxScore(String jewels) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < jewels.length(); i++) {
            if (stack.size() > 0 && stack.peek() == jewels.charAt(i)) {
                res++;
                stack.pop();
            } else {
                stack.add(jewels.charAt(i));
            }
        }
        return res;
    }
}