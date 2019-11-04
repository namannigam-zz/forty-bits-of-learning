package edu.forty.bits.ps.competitive.wynk;

/**
 * Created by naman.nigam on 13/01/17.
 */
public class Q16 {

    public static void main(String[] args) {

        int[] ar = {1, 2, 3, 4};
        int[] res = findMaximumNumber(ar, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] findMaximumNumber(int[] array, int moves) {
        int n = array.length;
        int max = value(array);
        // return if no swaps left
        if (moves == 0) {
            return array;
        }

        // consider every digit
        for (int a = 0; a < n - 1; a++) {
            // and compare it with all digits after it
            for (int b = a + 1; b < n; b++) {
                if (array[a] < array[b]) {
                    int k = array[a];
                    array[a] = array[b];
                    array[b] = k;
                }
                if (value(array) > max) {
                    max = value(array);
                }
                findMaximumNumber(array, moves - 1);

                int temp = array[a];
                array[a] = array[b];
                array[b] = temp;
            }
        }
        return array;
    }

    static void swap(int i, int j) {
        int k = i;
        i = j;
        j = k;
    }

    static int value(int[] array) {
        int arrayValue = 0;
        int ind = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            arrayValue += array[i] * Math.pow(10, ind);
            ind++;
        }
        return arrayValue;
    }
}