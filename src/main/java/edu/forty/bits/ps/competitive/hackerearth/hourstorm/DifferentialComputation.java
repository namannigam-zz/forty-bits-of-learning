package org.practice.learning.competitive.hackerearth.hourstorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * You have been given an array  of size . Now, let's call the weight of a subsequence the xor of all elements it contains.The weight of a subsequence containing  elements is . Now, you need to find the summation of xor of each subsequence  the length of the subsequence over all  subsequences of the given array .
 *
 * As the answer can be rather large, print it Modulo
 * Can you do it ?
 *
 * Input Format :
 *
 * The first line contains a single integer  denoting the size of the given array . The next line contains  integers, where the  integer denotes .
 *
 * Output Format:
 *
 * Print a single integer denoting the answer. As the answer can be rather large, print it Modulo
 * Input Constraints :
 *
 * Note that the Expected Output Feature for Custom Invocation is not supported for this contest.
 */
public class DifferentialComputation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
        }

        System.out.println(printResult(arr));
    }

    private static long xor(List<Long> integers) {
        long acc = 0;
        for (Long i : integers) {
            acc = acc ^ i;
        }
        return acc;
    }


    private static long printResult(long set[]) {
        int n = set.length;
        long M = 998244353;
        long sum = 0;
        for (int i = 0; i < (1 << n); i++) {
            List<Long> list = new ArrayList<>();
            // Print current subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(set[j]);
                }
            }
            sum = (sum + xor(list) * list.size()) % M;
        }
        return sum;
    }

    // =====================================================SOLUTION COPIED==========================================//

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int mod = 998244353;
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
        long ans = 0;
        for (int d = 60; d >= 0; d--) {
            int o = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] << ~d < 0) o++;
            }

            // [0,n-o]
            // 2^(n-o-1)*(n-o)*2^(o-1)
            // 1*C(o,1)+3*C(o,3)+..
            // 0 1 2 6 16 40
            ans *= 2;
            if (o >= 1) {
                long g = o == 1 ? 1 : (long) o * pow(2, o - 2, mod) % mod;
                ans += g * pow(2, n - o, mod);
                ans += pow(2, n - 2, mod) * (n - o);
            }
            ans %= mod;
        }
        System.out.println(ans);
    }

    private static long pow(long a, long n, long mod) {
        //a %= mod;
        long ret = 1;
        int x = 63 - Long.numberOfLeadingZeros(n);
        for (; x >= 0; x--) {
            ret = ret * ret % mod;
            if (n << 63 - x < 0) {
                ret = ret * a % mod;
            }
        }
        return ret;
    }
}