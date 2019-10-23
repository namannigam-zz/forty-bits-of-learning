package org.practice.learning.competitive.wissen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * One value
 * You are given an empty list of integers. Now you have to process three types of queries on this list -
 *
 *  : Insert the given integer  in the list.
 *  : Remove one instance of the integer  from the list if it exists.
 *  : Find the integer with least frequency, if there are multiple answers with same frequency then output the largest number amongst them.
 *  : Find the integer with highest frequency. If there are multiple answers with the same frequency then output the smallest number amongst them.
 *  Input
 * First line contains a number  as input denoting total number of queries. Next   lines contain description of all the  queries.
 *
 * Output
 * For each query of type  and type  you have to print the answer required if the list is not empty or else you need to print  if list is empty in a new line.
 */
public class OneValueOpsUsingComparator {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> inputToFrequencyMap = new HashMap<>(M);
        for(int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(tk.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(tk.nextToken());
                add_to_list(val, inputToFrequencyMap);
            } else if (type == 2) {
                int val = Integer.parseInt(tk.nextToken());
                remove_from_list(val, inputToFrequencyMap);
            } else if (type == 3) {
                int ans = finalLeastFrequentLargestElement(inputToFrequencyMap);
                System.out.println(ans);
            } else if (type == 4) {
                int ans = finalMostFrequentSmallestElement(inputToFrequencyMap);
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

    private static int finalLeastFrequentLargestElement(Map<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> some = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> frequency = Map.Entry.comparingByKey();
        Comparator<Map.Entry<Integer, Integer>> value = Collections.reverseOrder(Map.Entry.comparingByValue());
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }

    private static int finalMostFrequentSmallestElement(Map<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> some = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> frequency = Collections.reverseOrder(Map.Entry.comparingByKey());
        Comparator<Map.Entry<Integer, Integer>> value = Map.Entry.comparingByValue();
        some.sort(frequency.thenComparing(value));
        return some.iterator().next().getKey();
    }
}