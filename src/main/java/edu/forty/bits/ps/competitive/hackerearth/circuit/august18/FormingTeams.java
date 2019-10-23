package org.practice.learning.competitive.hackerearth.circuit.august18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * MacroSoft, one of the largest company in the world has recently got a huge fund for a large project. Mr. X, the CEO of MacroSoft is very excited about the project and is planning to divide all of his employees into different teams to distribute the tasks. In MacroSoft each employee has got exactly one supervisor except Mr. X. Of course! Why would he need one? He’s the CEO! Also, each of the employees including Mr. X has got a rank in the company. As you are the project manager, you need to help Mr. X dividing the employees into maximum K teams in such a way that each member belongs to exactly one of the teams and the maximum imbalance value among all the teams is minimized.
 *
 * You can form a team with any subset of employees S if it satisfies the following conditions:
 *
 * There should be exactly one employee w in the subset S whose supervisor doesn’t exist in S and w will be the team leader of that team.
 *
 * For any employee u (excluding w), if u exist in the set S, then the supervisor of u must also exist in the set S.
 *
 * Now the imbalance value of a team depends on the rank of all the team members. For each employee, u, take the difference between the rank of u and the rank of the team leader. The imbalance value of the team is the maximum values among all the differences. You have to minimize the maximum imbalance value among all the teams.
 *
 * Constraints
 *
 * 1 <= T <= 3
 * 1 <= N <= 1000
 * 1 <= K <= N
 * 0 <= Ai <= 10^9
 * Input Format
 *
 * The first line contains T, the number of test cases. The first line of a test case contains two integers N and K. N is the number of employees in the company and K is the maximum number of teams you can form. The second line contains N space separated integers representing the array A, where Ai is the rank of employee i. Each of the next N-1 lines contains two integers u and v, which means that u is the supervisor of employee v.
 *
 * Output Format
 *
 * For each test cases, print a single integer, the maximum imbalance value of the team which is minimized.
 */
public class FormingTeams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            List<Integer> ranks = IntStream.range(0, N)
                    .mapToObj(j -> scanner.nextInt())
                    .collect(Collectors.toCollection(() -> new ArrayList<>(N)));
            List<Edge> edges = IntStream.range(0, N - 1)
                    .mapToObj(j -> new Edge(scanner.nextInt(), scanner.nextInt()))
                    .collect(Collectors.toList());
        }
    }


    private static class Edge {
        int superior;
        int employee;

        Edge(int u, int v) {
            this.superior = u;
            this.employee = v;
        }
    }
}