package edu.forty.bits.ps.competitive.hackerearth.arena;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumAbsDifferenceSummation {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int arr[] = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
    //        Arrays.sort(arr);
    //
    //        int[] finalArr = new int[N];
    //        int a = 0;
    //        int b = 1;
    //
    //        for(int i = 0; i < arr.length; i++) {
    //            if (i % 2 == 0) {
    //                finalArr[i] = arr[a];
    //                a++;
    //            } else {
    //                finalArr[i] = arr[N - b];
    //                b++;
    //            }
    //        }
    //        int sum = IntStream.range(1, finalArr.length).map(i -> Math.abs(finalArr[i] -
    // finalArr[i - 1])).sum();
    System.out.println(maxSum(arr));
  }

  // Return the maximum Sum of difference between
  // consecutive elements.
  private static int maxSum(int arr[]) {
    int sum = 0;
    Arrays.sort(arr);

    // Subtracting a1, a2, a3,....., a(n/2)-1,
    // an/2 twice and adding a(n/2)+1, a(n/2)+2,
    // a(n/2)+3,....., an - 1, an twice.
    for (int i = 0; i < arr.length / 2; i++) {
      sum -= (2 * arr[i]);
      sum += (2 * arr[arr.length - i - 1]);
    }

    return sum;
  }
}
