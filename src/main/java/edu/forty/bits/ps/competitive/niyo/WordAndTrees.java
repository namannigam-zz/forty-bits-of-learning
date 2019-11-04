package edu.forty.bits.ps.competitive.niyo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordAndTrees {

  /**
   * Words And Trees You are given a rooted tree with N nodes. Each node contains a lowercase
   * English letter. Node with label 1
   *
   * <p>1 is the root.There are Q questions of the form
   *
   * <p>X S: Here X is the root of subtree and S is a com.stackoverflow.nullpointer.string.
   *
   * <p>For each question, let T be the com.stackoverflow.nullpointer.string built using all the
   * characters in the nodes of subtree with root X (each subtree node character comes exactly once)
   * . For each question, print minimum number of characters to be added to T , so that the we can
   * build S using some characters of com.stackoverflow.nullpointer.string T (each character of
   * com.stackoverflow.nullpointer.string T can be used at most once).
   *
   * <p>Input Format
   *
   * <p>The first line of input consists of two space separated integers N N and Q Q that are number
   * of nodes in the tree and number of questions respectively. Next line will contain N N space
   * separated lowercase English letters, where
   *
   * <p>ith letter will be the letter stored in node with label i
   *
   * <p>
   *
   * <p>Each of the next N-1 lines contains two space separated integers
   *
   * <p>u and v that denote there is an edge between nodes with labels
   *
   * <p>Next Q lines follow. Each line will contain an integer X that denotes the node label and a
   * com.stackoverflow.nullpointer.string S separated by a single space.
   *
   * <p>Output Format
   *
   * <p>For each query, print the required answer in a new line.
   *
   * <p>
   *
   * <p>Sample Input 8 3 o v s l v p d i 1 3 8 3 4 8 6 1 5 3 7 6 2 3 7 ifwrxl 4 eyljywnm 3 llvse
   *
   * <p>Sample Output 6 7 2 Explanation Query 1- Character in the subtree with root 7 is d, we need
   * 6 characters(i,f,w,r,x,l) to make S=(ifwrxl).
   *
   * <p>Query 2- Character in the subtree with root 4 is l, we need 7 characters(e,y,j,y,w,n,m) to
   * make S=(eyljywnm).
   *
   * <p>Query 3- Characters in the subtree with root 3 are (v,s,i,l), we need 2 characters(l,e) to
   * make S=(llvse).
   *
   * <p>Note: Your code should be able to convert the sample input into the sample output. However,
   * this is not enough to pass the challenge, because the code will be run on multiple test cases.
   * Therefore, your code must solve this problem statement.
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int N = s.nextInt();
    int Q = s.nextInt();

    List<Node> inputList =
        IntStream.range(1, N + 1)
            .mapToObj(i -> new Node(i, s.nextLine().charAt(0)))
            .collect(Collectors.toList());

    Map<Integer, List<Integer>> edgeList = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int u = s.nextInt();
      int v = s.nextInt();
      List<Integer> values = new ArrayList<>(u);
      if (edgeList.get(v) != null) {
        values.addAll(edgeList.get(v));
      }
      edgeList.put(v, values);
    }

    TreeSet<Node> treeSet = new TreeSet<>();
  }

  static class Node {
    int label;
    char ch;
    List<Node> conenctedNodes;

    Node(int label, char ch) {
      this.ch = ch;
      this.label = label;
    }
  }
}
