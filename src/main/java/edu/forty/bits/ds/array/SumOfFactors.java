package edu.forty.bits.ds.array;

import static java.lang.Math.sqrt;

public class SumOfFactors {

    /**
     * @see <href>https://www.geeksforgeeks.org/sum-factors-number</href>
     * <p>
     * Returns sum of all factors of n.
     */

    int sumofFactors(int n) {
        // Traversing through all prime factors.
        int res = 1;
        for (int i = 2; i <= sqrt(n); i++) {

            // While i divides n, print i and divide n
            int count = 0, curr_sum = 1, curr_term = 1;
            while (n % i == 0) {
                count++;

                // NOTE : THE BELOW STATEMENT MAKES
                // IT BETTER THAN ABOVE METHOD AS WE
                // REDUCE VALUE OF n.
                n = n / i;

                curr_term *= i;
                curr_sum += curr_term;
            }

            res *= curr_sum;
        }

        // This condition is to handle the case when n
        // is a prime number.
        if (n >= 2)
            res *= (1 + n);

        return res;
    }
}