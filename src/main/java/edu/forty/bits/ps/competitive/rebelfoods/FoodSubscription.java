package edu.forty.bits.ps.competitive.rebelfoods;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FoodSubscription {

  private static final int ONE_DAY_SUB = 199;
  private static final int SEVEN_DAY_SUB = 699;
  private static final int THIRTY_DAY_SUB = 2499;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    List<Integer> days =
        IntStream.range(0, N).mapToObj(i -> scanner.nextInt()).collect(Collectors.toList());
    int cost = minimumSubscriptionCost(days);
    System.out.println(cost);
  }

  private static int minimumSubscriptionCost(List<Integer> days) {
    if (days.size() > 17) return THIRTY_DAY_SUB;
    if (days.size() < 4) return ONE_DAY_SUB * days.size();
    int val = days.get(0); // first index
    int cost = 0;
    while (val < 31) {
      int start = val;
      int countDays = countDaysInAWeek(days, start);
      if (countDays > 3) {
        days = days.stream().filter(d -> d >= start + 7).collect(Collectors.toList());
        val = days.get(0);
        cost += SEVEN_DAY_SUB;
      } else {
        days = days.subList(1, days.size());
        val = days.get(0);
        cost = cost + ONE_DAY_SUB;
      }
    }
    return cost;
  }

  private static int countDaysInAWeek(List<Integer> days, int startDay) {
    int count = 0;
    for (int i = startDay; i < startDay + 7 && i < 31; i++) {
      for (int day : days) {
        if (day == i) {
          count++;
        }
      }
    }
    return count;
  }
}
