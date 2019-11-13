package edu.forty.bits.ds.array;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class IsPrime {

  boolean isPrimeBitsCheck(int n) {
    return !new String(new char[n]).matches(".?|(..+?)\\1+");
  }

  public boolean isProbablePrime(int n) {
    return BigInteger.valueOf(n).isProbablePrime(50);
  }

  boolean isPrimeStream(int n) {
    return IntStream.range(2, n) // note  division by zero possible in your attempt
        .noneMatch(i -> n % i == 0);
  }

  boolean isPrime(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  boolean isPrimeStreamOptimised(int n) {
    return IntStream.iterate(2, i -> i * i <= n, i -> i + 1).noneMatch(i -> n % i == 0);
  }
}