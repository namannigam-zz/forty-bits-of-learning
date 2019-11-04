package edu.forty.bits.ps.competitive.wissen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * One value You are given an empty list of integers. Now you have to process three types of queries
 * on this list -
 *
 * <p>: Insert the given integer in the list. : Remove one instance of the integer from the list if
 * it exists. : Find the integer with least frequency, if there are multiple answers with same
 * frequency then output the largest number amongst them. : Find the integer with highest frequency.
 * If there are multiple answers with the same frequency then output the smallest number amongst
 * them. Input First line contains a number as input denoting total number of queries. Next lines
 * contain description of all the queries.
 *
 * <p>Output For each query of type and type you have to print the answer required if the list is
 * not empty or else you need to print if list is empty in a new line.
 */
public class OneValueOps {

  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    Map<Integer, Integer> inputToFrequencyMap = new HashMap<>(M);
    for (int i = 0; i < M; i++) {
      StringTokenizer tk = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(tk.nextToken());
      if (type == 1) {
        int val = Integer.parseInt(tk.nextToken());
        add_to_list(val, inputToFrequencyMap);
      } else if (type == 2) {
        int val = Integer.parseInt(tk.nextToken());
        remove_from_list(val, inputToFrequencyMap);
      } else if (type == 3) {
        int ans = find_least_frequency(inputToFrequencyMap);
        System.out.println(ans);
      } else if (type == 4) {
        int ans = find_highest_frequency(inputToFrequencyMap);
        System.out.println(ans);
      }
    }
  }

  private static void add_to_list(int val, Map<Integer, Integer> inputToFrequencyMap) {
    if (inputToFrequencyMap.containsKey(val)) {
      int count = inputToFrequencyMap.get(val);
      inputToFrequencyMap.put(val, count + 1);
    } else {
      inputToFrequencyMap.put(val, 1);
    }
  }

  private static void remove_from_list(int val, Map<Integer, Integer> inputToFrequencyMap) {
    if (inputToFrequencyMap == null || !inputToFrequencyMap.containsKey(val)) return;
    if (inputToFrequencyMap.containsKey(val) && inputToFrequencyMap.get(val) == 1) {
      inputToFrequencyMap.remove(val);
    } else {
      int count = inputToFrequencyMap.get(val);
      inputToFrequencyMap.put(val, count - 1);
    }
  }

  private static int find_least_frequency(Map<Integer, Integer> inputToFrequencyMap) {
    if (inputToFrequencyMap.isEmpty()) {
      return -1;
    }
    int leastFrequentValue = inputToFrequencyMap.entrySet().iterator().next().getValue();
    int largestElementValue = inputToFrequencyMap.entrySet().iterator().next().getKey();
    for (Map.Entry<Integer, Integer> a : inputToFrequencyMap.entrySet()) {
      if (a.getValue() < leastFrequentValue) {
        leastFrequentValue = a.getValue();
        largestElementValue = a.getKey();
      }
      if (a.getValue() == leastFrequentValue) {
        if (a.getKey() > largestElementValue) {
          largestElementValue = a.getKey();
        }
      }
    }
    return largestElementValue;
  }

  private static int find_highest_frequency(Map<Integer, Integer> inputToFrequencyMap) {
    if (inputToFrequencyMap.isEmpty()) {
      return -1;
    }
    int mostFrequentValue = inputToFrequencyMap.entrySet().iterator().next().getValue();
    int smallestElementValue = inputToFrequencyMap.entrySet().iterator().next().getKey();
    for (Map.Entry<Integer, Integer> a : inputToFrequencyMap.entrySet()) {
      if (a.getValue() > mostFrequentValue) {
        mostFrequentValue = a.getValue();
        smallestElementValue = a.getKey();
      }
      if (a.getValue() == mostFrequentValue) {
        if (a.getKey() < smallestElementValue) {
          smallestElementValue = a.getKey();
        }
      }
    }
    return smallestElementValue;
  }

  private static int findLeastFrequentLargestElement(Map<Integer, Integer> hashMap) {
    if (hashMap == null || hashMap.isEmpty()) {
      return -1;
    }

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Map<Integer, Integer> sortedByValueMap =
        list.stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    int leastFrequentValue = sortedByValueMap.entrySet().iterator().next().getValue();
    int largestElementValue = sortedByValueMap.entrySet().iterator().next().getKey();
    List<Map.Entry<Integer, Integer>> x =
        sortedByValueMap.entrySet().stream()
            .filter(m -> m.getValue() == leastFrequentValue)
            .collect(Collectors.toList());
    for (Map.Entry<Integer, Integer> a : x) {
      if (largestElementValue < a.getKey()) {
        largestElementValue = a.getKey();
      }
    }
    return largestElementValue;
  }

  private static int findMostFrequentSmallestElement(Map<Integer, Integer> hashMap) {
    if (hashMap == null || hashMap.isEmpty()) {
      return -1;
    }
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
    list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
    Map<Integer, Integer> sortedByValueMap =
        list.stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    int mostFrequentValue = sortedByValueMap.entrySet().iterator().next().getValue();
    int smallestElementValue = sortedByValueMap.entrySet().iterator().next().getKey();
    List<Map.Entry<Integer, Integer>> x =
        sortedByValueMap.entrySet().stream()
            .filter(m -> m.getValue() == mostFrequentValue)
            .collect(Collectors.toList());
    for (Map.Entry<Integer, Integer> a : x) {
      if (smallestElementValue > a.getKey()) {
        smallestElementValue = a.getKey();
      }
    }
    return smallestElementValue;
  }
}
