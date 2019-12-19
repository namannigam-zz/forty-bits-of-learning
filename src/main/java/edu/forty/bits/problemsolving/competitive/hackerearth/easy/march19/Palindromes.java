package edu.forty.bits.problemsolving.competitive.hackerearth.easy.march19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        B = new StringBuffer(B).reverse().toString();

        List<String> subStringA = subStrings(A);
        List<String> subStringB = subStrings(B);

        int max = 0;
        for (String s1 : subStringA) {
            for (String s : subStringB) {
                String f = s1 + s;
                if (isPalindrome(f) && f.length() > max) {
                    max = f.length();
                }
            }
        }
        System.out.println(max);
    }

    static int LCSubStr(char[] X, char[] Y) {
        int[][] LCStuff = new int[X.length + 1][Y.length + 1];
        int result = 0; // To store length of the longest common substring
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                if (i == 0 || j == 0) LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                } else LCStuff[i][j] = 0;
            }
        }
        return result;
    }

    private static List<String> subStrings(String str) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    private static boolean isPalindrome(String str) {
        String reverse = new StringBuffer(str).reverse().toString();
        return str.equals(reverse);
    }
}
