package edu.forty.bits.ps.competitive.expedia;

public class ConsectiveSubArrayWithSumDivisibleByK {

  static long kSub(int k, int[] nums) {
    int mod[] = new int[k]; // array to count frequency of remainders
    int consecutiveSum = 0; // sum of sequence of values
    for (int num : nums) { // Traverse original array
      consecutiveSum += num; // compute sum of consecutives
      mod[
          (consecutiveSum
              % k)]++; // increase count by 1 for the remainder of the sum with k in mod[] array
    }

    long result = 0; // result count

    // Traverse the remainder array
    for (int i = 0; i < k; i++) {
      // If there are more than one prefix subarrays with a particular mod value.
      if (mod[i] > 1) {
        result += (mod[i] * (mod[i] - 1)) / 2;
      }
    }

    // add the elements which are divisible by k itself
    result += mod[0];

    return result;
  }
}
