package edu.forty.bits.ds.sorting;

import java.util.Arrays;

public class SortBenchmark {

    public static void main(String[] args) {
        int arr0[] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(arr0);
        System.out.println("\nSorted array");
        Arrays.stream(arr0).mapToObj(anArr -> anArr + " ").forEach(System.out::print);

        int arr1[] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.optimisedBubbleSort(arr1);
        System.out.println("\nSorted array");
        Arrays.stream(arr1).mapToObj(anArr -> anArr + " ").forEach(System.out::print);


        int arr2[] = {64, 34, 25, 12, 22, 11, 90};
        SelectionSort.selectionSort(arr2);
        System.out.println("\nSorted array");
        Arrays.stream(arr2).mapToObj(anArr -> anArr + " ").forEach(System.out::print);


        int arr3[] = {64, 34, 25, 12, 22, 11, 90};
        InsertionSort.insertionSort(arr3);
        System.out.println("\nSorted array");
        Arrays.stream(arr3).mapToObj(anArr -> anArr + " ").forEach(System.out::print);

        int arr4[] = {64, 34, 25, 12, 22, 11, 90};
        InsertionSort.binaryInsertionSort(arr4);
        System.out.println("\nSorted array");
        Arrays.stream(arr4).mapToObj(anArr -> anArr + " ").forEach(System.out::print);


        int arr5[] = {64, 34, 25, 12, 22, 11, 90};
        HeapSort.heapSort(arr5);
        System.out.println("\nSorted array");
        Arrays.stream(arr5).mapToObj(anArr -> anArr + " ").forEach(System.out::print);


        int arr6[] = {64, 34, 25, 12, 22, 11, 90};
        QuickSort.quickSort(arr6, 0, arr6.length - 1);
        System.out.println("\nSorted array");
        Arrays.stream(arr6).mapToObj(anArr -> anArr + " ").forEach(System.out::print);


        int arr7[] = {64, 34, 25, 12, 22, 11, 90};
        MergeSort.mergeSort(arr6, 0, arr7.length - 1);
        System.out.println("\nSorted array");
        Arrays.stream(arr7).mapToObj(anArr -> anArr + " ").forEach(System.out::print);
    }
}