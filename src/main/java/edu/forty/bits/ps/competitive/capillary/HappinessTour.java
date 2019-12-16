package edu.forty.bits.ps.competitive.capillary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Happiness Tour In Wonderland, there are N cities (enumerated from 1 to N) connected by
 * bidirectional roads. Every city has an associated happiness score related to it. Mike starts from
 * the capital city City1 , and can only travel from to , if the two cities are directly connected
 * through a road. The happiness of the city, , is added to Mike's own happiness when he travels
 * through the city. He can skip any number of cities while traveling, but that would reset his
 * happiness to 0 (that is, when Mike skips some city, his happiness is set back to 0). Once visited
 * or skipped, he would not be able to visit or skip that city again. Mike wants to find the maximum
 * happiness that can be achieved during his tour. Initially, Mike's happiness is zero. Your task is
 * to calculate the maximum happiness that Mike can achieve during his tour.
 *
 * <p>Input Format
 *
 * <p>The first line contains an integer T, denoting the number of test cases. For each testcase :
 * The first line contains an integer N, denoting the number of cities. The second line contains N
 * space-separated integers, the i-th of which is , denoting city has happiness score . The third
 * line contains M, the number of roads. The fourth and fifth lines contain space-separated
 * integers, the of which is and respectively. They denote that there is a bidirectional road
 * between and .
 *
 * <p>It is guaranteed that any city can be reached from any other city.
 *
 * <p>Output Format
 *
 * <p>For each test case, print the maximum amount of happiness that Mike can achieve. Answer for
 * each test case should come in a new line.
 */
public class HappinessTour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int a = 0; a < T; a++) {
            int N = scanner.nextInt(); // number of cities

            int[] Hi = new int[N]; // city happiness
            for (int b = 0; b < N; b++) {
                Hi[b] = scanner.nextInt();
            }

            Map<Integer, List<Integer>> srcToDestinationCity = new HashMap<>();

            int M = scanner.nextInt(); // number of roads (N-1)
            int[] srcCities = new int[M];
            int[] destCities = new int[M];

            for (int c = 0; c < M; c++) {
                srcCities[c] = scanner.nextInt();
            }
            for (int c = 0; c < M; c++) {
                destCities[c] = scanner.nextInt();
            }
        }
    }
}
