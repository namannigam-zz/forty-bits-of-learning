package edu.forty.bits.ps.competitive.hackerearth.arena;

import java.util.Scanner;

public class PlayerPasses {

  public static void main(String args[]) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      int initialPlayer = scanner.nextInt();

      int currenPlayer = initialPlayer;
      for (int j = 0; j < N; j++) {
        String move = scanner.next();
        if (move.contains("B")) {
          int temp = currenPlayer;
          currenPlayer = initialPlayer;
          initialPlayer = temp;
        } else {
          initialPlayer = currenPlayer;
          currenPlayer = scanner.nextInt();
        }
      }
      System.out.println(currenPlayer);
    }
  }
}
