package com.xym.datastructure.sort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        Sort selectionSort = new SelectionSort();
        Sort insertionSort = new InsertionSort();
        Sort bubbleSort = new BubbleSort();
        Sort shellSort = new ShellSort();
        Sort mergeSort = new MergeSort();
        Sort mergeSortBU = new MergeSortBU();
        Sort quickSort = new QuickSort();
        Sort quickSort3Ways = new QuickSort3Ways();
//        int[] arr1 = getRandomArr(100_000);
//        System.out.println(getSortTime(quickSort, arr1) + "ms");
//        System.out.println(isSorted(arr1));
//        int[] arr2 = getRandomArr(1000_000);
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(getSortTime(quickSort3Ways, arr2) + "ms");
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(isSorted(arr2));

        int[] arr = getRandomArr(10);
        System.out.println(Arrays.toString(arr));

        int[] res = Arrays.copyOfRange(arr,5,12);
        System.out.println(Arrays.toString(res));

    }

    private static int[] getOrderedArr(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] getRandomArr(int length) {
        int[] arr = new int[length];
        Random r = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(length);
        }
        return arr;
    }

    private static double getSortTime(Sort sortMethod, int[] arr) {
        long time1 = System.nanoTime();
        sortMethod.sort(arr);
        long time2 = System.nanoTime();
        return (double) (time2 - time1) / 1000_000.0;
    }

    private static boolean isSorted(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            if (sort[i] < sort[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
