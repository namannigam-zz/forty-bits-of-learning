package edu.forty.bits.ps.competitive.hackerearth.easy.august18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Pikachu loves battling with other Pokemon. This time he has a team of Meowstic to fight, of which
 * has strength . He wants to fight with all of them times. Team Meowstic came to know about this
 * and now they have devised a strategy to battle against the mighty Pikachu.
 *
 * <p>All the Meowstic stand in a straight line numbered from to . Before every round of battle,
 * they simultaneously use a move, called Helping Hand. It changes the attacking power of Team
 * Meowstic as follows:
 *
 * <p>The attacking power of first Meowstic remains . The attacking power of remaining Meowstic
 * changes as where and represents the bitwise OR of and For example, if the current attacking
 * powers are , after using the Helping Hand, the powers change to , or .
 *
 * <p>Help Pikachu by finding the attacking powers of all Meowstic when he fights each of them for
 * the last time, that is, for the round.
 *
 * <p>Note that, the influence of Helping Hand remains forever, and attacking powers DO NOT revert
 * back after any round.
 *
 * <p>Constraints:
 *
 * <p>Input format:
 *
 * <p>First line contains two space separated integers, and Second line contains space separated
 * integers, the of which is
 */
public class PickachuVsTeamMeawostic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int arr[] = IntStream.rangeClosed(1, n).map(i -> scanner.nextInt()).toArray();
        Arrays.stream(updatedPowers(arr, k))
                .mapToObj(anArrup -> anArrup + " ")
                .forEach(System.out::print);
    }

    private static int[] updatedPowers(int arr[], int k) {
        IntStream.range(0, k)
                .flatMap(i -> IntStream.range(1, arr.length))
                .forEach(j -> arr[j] = arr[j - 1] | arr[j]);
        return arr;
    }

    void mainSolution(int[] a, int n, int k) {
        int b[] = new int[100004];
        for (int j = 0; j < k && j <= 100; j++) {
            for (int i = 1; i < n; i++) {
                a[i] = a[i] | b[i - 1];
            }
            if (n >= 0) System.arraycopy(a, 0, b, 0, n);
        }

        IntStream.rangeClosed(1, n).mapToObj(i -> a[i] + " ").forEach(System.out::print);
    }
}
