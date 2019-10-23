package org.practice.learning.competitive.hackerearth.easy.september18;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int b = scanner.nextInt();

        int[] costOfLevelUpgrade = IntStream.range(0, m - 1).map(i -> scanner.nextInt()).toArray();
        int[] costOfSellingWeapon = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();

        int maxCoins = b;


    }

}