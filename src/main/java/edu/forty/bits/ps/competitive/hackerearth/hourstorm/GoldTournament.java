package edu.forty.bits.ps.competitive.hackerearth.hourstorm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Bob is organizing the annual tournament of gold. There are participants in a line, each starting
 * with gold. Initially, the entire row of participants is "selected". A round of the tournament
 * proceeds as follows:
 *
 * <p>Bob selects a random subarray of the currently "selected" part of the row. Each subarray has
 * equal probability of being chosen, including the same currently "selected" part. He gives gold to
 * each participant in the subarray. He sets this subarray as the new "selected" part of the row.
 * After rounds of the tournament proceed, what is the expected amount of gold of each participant ?
 *
 * <p>It can be proven that the expected amount of gold for the participant can be represented as a
 * fraction with and . Print space-separated integers, the of which is modulo It can be proved that
 * Modulo exists under the following constraints.
 *
 * <p>Input Format:
 *
 * <p>The first and only line of input contains two space-separated integers, and .
 *
 * <p>Output Format:
 *
 * <p>Print space separated integers, the integer denoting the answer for the participant .
 *
 * <p>Constraints:
 *
 * <p>Note that the Expected Output Feature for Custom Invocation is not supported for this contest.
 */
public class GoldTournament {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        int mod = 998244353;
        long[][] P = new long[n + 1][n + 1];
        P[0][n - 1] = 1;
        long[] il = IntStream.range(0, 1000).mapToLong(i -> invl((i + 2) * (i + 1) / 2, mod)).toArray();

        long[] imos = new long[n + 1];
        for (int i = 0; i < K; i++) {
            long[][] NP = new long[n + 1][n + 1];
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    // (k-j+1)*(k-j)/2;
                    NP[j][k] = P[j][k] * il[k - j] % mod;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = n; k >= 1; k--) {
                    NP[j][k - 1] += NP[j][k];
                    if (NP[j][k - 1] >= mod) NP[j][k - 1] -= mod;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    NP[k + 1][j] += NP[k][j];
                    if (NP[k + 1][j] >= mod) NP[k + 1][j] -= mod;
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    imos[j] += NP[j][k];
                    imos[k + 1] -= NP[j][k];
                }
            }

            P = NP;
        }

        IntStream.range(0, n)
                .forEach(
                        j -> {
                            imos[j] %= mod;
                            if (imos[j] < 0) imos[j] += mod;
                            imos[j + 1] += imos[j];
                        });
        IntStream.range(0, n).mapToObj(j -> imos[j] + " ").forEach(System.out::println);
    }

    private static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }
}
