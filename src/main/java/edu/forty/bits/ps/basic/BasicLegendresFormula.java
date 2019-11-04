package edu.forty.bits.ps.basic;

// Java program to find largest power of
// a number (which may be composite) that
// divides factorial.

/**
 * @see <href>https://www.geeksforgeeks.org/find-maximum-power-number-divides-factorial/</href>
 */
public class BasicLegendresFormula {


    // for find maximum power of prime number
    // p which can divide fact number
    private static int findPowerPrime(int fact, int p) {
        int res = 0;
        while (fact > 0) {
            res += fact / p;
            fact /= p;
        }

        return res;
    }

    // Returns sum of all factors of n.
    private static int findPowerComposite(int fact, int n) {
        // To store result (minimum power of a
        // prime factor that divides fact! )
        int res = Integer.MAX_VALUE;

        // Traverse through all prime factors
        // of n.
        for (int i = 2; i <= Math.sqrt(n); i++) {

            // counter for count the
            // power of prime number
            int count = 0;
            if (n % i == 0) {
                count++;
                n = n / i;
            }

            if (count > 0) {

                // Maximum power of i that divides
                // fact!. We divide by count to
                // handle multiple occurrences of
                // a prime factor.
                int curr_pow = findPowerPrime(fact, i) / count;
                res = Math.min(res, curr_pow);
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2.
        if (n >= 2) {
            int curr_pow = findPowerPrime(fact, n);
            res = Math.min(res, curr_pow);
        }

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int fact = 146, n = 5;
        System.out.println(findPowerComposite(fact, n));
    }
}