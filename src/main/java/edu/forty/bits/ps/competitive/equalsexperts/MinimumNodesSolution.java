package edu.forty.bits.ps.competitive.equalsexperts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumNodesSolution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int N = s.nextInt();
    int Q = s.nextInt();

    List<Vertex> input = new ArrayList<>();

    IntStream.rangeClosed(1, N)
        .forEach(
            a -> {
              int val = s.nextInt();
              input.add(a, new Vertex(val));
            });

    IntStream.range(0, N - 1)
        .forEach(
            a -> {
              int u = s.nextInt();
              int v = s.nextInt();
              input.get(u).getConnectedWith().add(v);
              input.get(v).getConnectedWith().add(u);
            });

    IntStream.range(0, Q)
        .forEach(
            q -> {
              int x = s.nextInt();
              int k = s.nextInt();

              input
                  .get(x)
                  .getConnectedWith()
                  .forEach(
                      a -> {
                        int sumVal = input.get(x).getVal() + input.get(a).getVal();
                        int n = 2;
                        while (sumVal < k) {
                          input.get(a).getConnectedWith();
                        }
                      });
            });
  }

  static class Vertex {
    int val;
    List<Integer> connectedWith;

    Vertex(int val) {
      this.val = val;
    }

    int getVal() {
      return val;
    }

    void setVal(int val) {
      this.val = val;
    }

    List<Integer> getConnectedWith() {
      return connectedWith;
    }

    void setConnectedWith(List<Integer> connectedWith) {
      this.connectedWith = connectedWith;
    }
  }
}
