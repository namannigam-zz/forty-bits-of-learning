package edu.forty.bits.ps.competitive.hackerearth.arena;

import java.util.Arrays;
import java.util.Scanner;

public class LuckyString {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer N = scanner.nextInt();
    String S = scanner.next();
    int mid = N / 2;
    char[] firstHalf = S.substring(0, mid).toCharArray();
    char[] secondHalf = S.substring(mid, N).toCharArray();

    Arrays.sort(firstHalf);
    Arrays.sort(secondHalf);

    int countFirstGreater = 0;
    int countSecondGreater = 0;
    int countEqual = 0;

    for (int i = 0; i < mid; i++) {
      if (firstHalf[i] == secondHalf[i]) {
        countFirstGreater++;
        countSecondGreater++;
      }
      if (firstHalf[i] > secondHalf[i]) {
        countEqual++;
        countSecondGreater++;
      }
      if (firstHalf[i] < secondHalf[i]) {
        countEqual++;
        countFirstGreater++;
      }
    }

    System.out.println(min(countEqual, min(countFirstGreater, countSecondGreater)));
  }

  private static int min(int a, int b) {
    return a < b ? a : b;
  }
}
