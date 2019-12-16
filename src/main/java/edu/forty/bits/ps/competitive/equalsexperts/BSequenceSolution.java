package edu.forty.bits.ps.competitive.equalsexperts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BSequenceSolution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BSequence bSequence = new BSequence(Integer.MIN_VALUE, new ArrayList<>(), new ArrayList<>());

        int N = s.nextInt();
        IntStream.range(0, N)
                .forEach(
                        i -> {
                            int n = s.nextInt();
                            if (n > bSequence.getMaxVal()) {
                                bSequence.getLeft().add(n);
                                bSequence.setMaxVal(n);
                            }
                            if (n < bSequence.getMaxVal()) {
                                bSequence.getRight().add(n);
                            }
                        });

        int Q = s.nextInt();

        IntStream.range(0, Q)
                .forEach(
                        q -> {
                            BSequence updatedSequence = constructBSequence(s.nextInt(), bSequence);
                            System.out.println(
                                    updatedSequence.getLeft().size() + updatedSequence.getRight().size());
                        });

        bSequence.getLeft().forEach(a -> System.out.print(a + " "));
        bSequence.getRight().forEach(a -> System.out.print(a + " "));
    }

    private static BSequence constructBSequence(Integer q, BSequence bSequence) {
        if (q.equals(bSequence.getMaxVal())) {
            return bSequence;
        } else if (q > bSequence.getMaxVal()) {
            bSequence.getLeft().add(q);
            bSequence.setMaxVal(q);
        } else {
            if (bSequence.getLeft().contains(q)) {
                if (bSequence.getRight().contains(q)) {
                    return bSequence; // do not modify if in both the sides
                } else {
                    List<Integer> right = insertInSortedSequence(bSequence.getRight(), q, false);
                    bSequence.setRight(right);
                }
            } else {
                List<Integer> left = insertInSortedSequence(bSequence.getLeft(), q, true);
                bSequence.setLeft(left);
            }
        }
        return bSequence;
    }

    private static List<Integer> insertInSortedSequence(
            List<Integer> input, Integer val, boolean asc) {
        if (asc) {
            IntStream.range(0, input.size())
                    .filter(i -> val < input.get(i))
                    .findFirst()
                    .ifPresent(i -> input.add(i, val));
        } else {
            if (val < input.get(input.size() - 1)) {
                input.add(val);
            } else {
                IntStream.range(0, input.size())
                        .filter(i -> val > input.get(i))
                        .findFirst()
                        .ifPresent(i -> input.add(i, val));
            }
        }
        return input;
    }

    static class BSequence {
        Integer maxVal;
        List<Integer> left;
        List<Integer> right;

        BSequence(Integer maxVal, List<Integer> left, List<Integer> right) {
            this.maxVal = maxVal;
            this.left = left;
            this.right = right;
        }

        Integer getMaxVal() {
            return maxVal;
        }

        void setMaxVal(Integer maxVal) {
            this.maxVal = maxVal;
        }

        List<Integer> getLeft() {
            return left;
        }

        void setLeft(List<Integer> left) {
            this.left = left;
        }

        List<Integer> getRight() {
            return right;
        }

        void setRight(List<Integer> right) {
            this.right = right;
        }
    }
}
