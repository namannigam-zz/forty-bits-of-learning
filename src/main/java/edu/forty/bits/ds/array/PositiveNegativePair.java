package edu.forty.bits.ds.array;

import java.util.Arrays;

/**
 * @see
 *     <href>https://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0#ExpectOP</href>
 */
public class PositiveNegativePair {

  public static int[] positiveNegativePairs(int[] input) {
    int[] output = new int[input.length];
    int c = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[i] == input[j] * -1) {
          output[c++] = input[i];
          output[c++] = input[j];
        }
      }
    }
    return output;
  }


  public static void main(String[] args) {
    Object o1 = new Object() {
      String getSomething() {
        return "AAA";
      }
    };
    System.out.println(o1.getClass());
//    o1.getSomething(); // FAILS
    String methods1 = Arrays.toString(o1.getClass().getDeclaredMethods());
    var o2 = new Object() {
      String getSomething() {
        return "AAA";
      }
    };
    o2.getSomething(); // OK
    String methods2 = Arrays.toString(o2.getClass().getMethods());
    System.out.println(methods1.equals(methods2));
  }
}
