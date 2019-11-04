package edu.forty.bits.ps.competitive.hackerearth.easy.march19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      List<Integer> input =
          IntStream.range(0, N).mapToObj(a -> scanner.nextInt()).collect(Collectors.toList());
      List<Integer> initialState = new ArrayList<>(input);
      int operation = 0;
      while (!identityPermutation(input)) {
        input = transformOperation(input);
        operation++;
        if (initialState.equals(input)) break;
      }
      if (initialState.equals(input)) {
        System.out.println(-1);
      } else {
        System.out.println(operation);
      }
    }
  }

  private static List<Integer> transformOperation(List<Integer> permutation) {
    return permutation.stream()
        .map(integer -> permutation.get(integer - 1))
        .collect(Collectors.toList());
  }

  private static boolean identityPermutation(List<Integer> permutation) {
    return IntStream.range(0, permutation.size()).allMatch(i -> permutation.get(i) == i + 1);
  }
}
