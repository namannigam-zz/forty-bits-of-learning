package edu.forty.bits.ps.competitive.hackerearth.hourstorm;

import java.util.Scanner;

/**
 * There is a frog initially placed at the origin of the coordinate plane. In exactly second, the
 * frog can either move up unit, move right unit, or stay still. In other words, from position , the
 * frog can spend second to move to:
 *
 * <p>After seconds, a villager who sees the frog reports that the frog lies on or inside a square
 * of side-length with coordinates , , , . Calculate how many points with integer coordinates on or
 * inside this square could be the frog's position after exactly seconds
 *
 * <p>Input Format:
 *
 * <p>The first and only line of input contains four space-separated integers: , , , and .
 *
 * <p>Output Format:
 *
 * <p>Print the number of points with integer coordinates that could be the frog's position after
 * seconds.
 *
 * <p>Constraints:
 *
 * <p>Note that the Expected Output Feature for Custom Invocation is not supported for this contest.
 */
public class CountFrogPaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int S = scanner.nextInt();
        int T = scanner.nextInt();
        int count = 0;
        for (int i = X; i < X + S; i++) {
            for (int j = Y; j < Y + S; j++) {
                if ((i + j) <= T) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
