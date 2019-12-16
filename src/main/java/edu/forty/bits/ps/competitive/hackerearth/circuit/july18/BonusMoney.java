package edu.forty.bits.ps.competitive.hackerearth.circuit.july18;

import java.util.*;

/**
 * In a company, there are employees. Their productivities are numbered from to , each employee is
 * assigned with an unique number. At the end of year, their boss decided to reward bonus money for
 * them. The rule is that if A's productivity is greater than B's one then A's money must not less
 * than B's money. Your task is to find the number of ways to divide bonus money among employees
 * acoording to above rule. As the answer can be very large, you only need to find it modulo .
 *
 * <p>Input Format
 *
 * <p>The first line contains two space-separated integers denoting the number of test cases and the
 * modulo.
 *
 * <p>Each test case is described in a single line containing two space-separated integers .
 *
 * <p>Output Format
 *
 * <p>For each test case, output a single line containing the answer.
 */
public class BonusMoney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long p = scanner.nextLong();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
        }
    }

    private static int countSets(int employeeCount, int totalSum) {
        if (employeeCount == 1) { // only one emplyee gets it all
            return 1;
        }
        if (employeeCount == 2) {
            return (totalSum / 2) + 1;
        }

        //        while(true){}
        return 0;
    }

    private static void getSubsets(
            List<Integer> superSet, int k, int idx, Set<Integer> current, List<Set<Integer>> solution) {
        // successful stop clause
        if (current.size() == k) {
            solution.add(new HashSet<>(current));
            return;
        }
        // unseccessful stop clause
        if (idx == superSet.size()) return;

        Integer x = superSet.get(idx);
        current.add(x);
        // "guess" x is in the subset
        getSubsets(superSet, k, idx + 1, current, solution);
        current.remove(x);
        // "guess" x is not in the subset
        getSubsets(superSet, k, idx + 1, current, solution);
    }

    private static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new HashSet<>(), res);
        return res;
    }

    private static int sumOfSet(Set<Integer> set) {
        return set.stream().mapToInt(s -> s).sum();
    }

    //    /* arr[]  ---> Input Array
    //  data[] ---> Temporary array to store current combination
    //  start & end ---> Staring and Ending indexes in arr[]
    //  index  ---> Current index in data[]
    //  r ---> Size of a combination to be printed */
    //    private static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
    //        // Current combination is ready to be printed,
    //        // print it
    //        if (index == r) {
    //            for(int j = 0; j < r; j++)
    //                System.out.print(data[j] + " ");
    //            System.out.println("");
    //            return;
    //        }
    //
    //        // When no more elements are there to put in data[]
    //        if (i >= n) return;
    //
    //        // current is included, put next at next
    //        // location
    //        data[index] = arr[i];
    //        combinationUtil(arr, n, r, index + 1, data, i + 1);
    //
    //        // current is excluded, replace it with
    //        // next (Note that i+1 is passed, but
    //        // index is not changed)
    //        combinationUtil(arr, n, r, index, data, i + 1);
    //    }
    //
    //    // The convertNumbersToName function that prints all combinations
    //    // of size r in arr[] of size n. This function
    //    // mainly uses combinationUtil()
    //    static void printCombination(int arr[], int n, int r) {
    //        // A temporary array to store all combination
    //        // one by one
    //        int data[] = new int[r];
    //
    //        // Print all combination using temprary
    //        // array 'data[]'
    //        combinationUtil(arr, n, r, 0, data, 0);
    //    }
}
