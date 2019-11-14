package edu.forty.bits.ds.array;

import lombok.Builder;

/**
 * You are given an array of integers(positive and negative both). Find the contiguous sequence with
 * largest sum and return the value. e.g. input -> 2, -8, 3, -2, 4, -10 output -> 5 (3,-2,4)
 */
public class ContiguousSequence {

  // the smallest such sequence would make much sense e.g. (2, 3, -3, 4, 2) vs (4,2)
  // creating all permutations and combinations and evaluating their sum would be too costly
  // sliding window approach would be a direction to look at
  // if the sum of any two consecutive number is less than or equal to 0, slide ahead
  // resolve the array as an alternate sequence of positive and negative values
  int maxSum(int[] array) {
    int maxSum = 0;
    int sum = 0;
    for (int value : array) {
      sum += value;
      if (maxSum < sum) {
        maxSum = sum;
      } else if (sum < 0) {
        sum = 0;
      }
    }
    return maxSum;
  }

  // If one was to persist the information of the elements included in this subsequence,
  // they can use a custom object to wrap the information around it.
  ResultBlock contiguousSequence(int[] array) {
    // this would need some time to complete
    return ResultBlock.builder().numberOfElements(array.length).build();
  }

  @Builder
  static class ResultBlock {
    int startIndex;
    int sum;
    int numberOfElements;
  }
}