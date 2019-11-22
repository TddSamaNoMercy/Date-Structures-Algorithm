package com.xym.datastructure.sort;

public class BubbleSort implements Sort {
    public int[] sort(int[] arr) {
        int n = 0;
        int swapIndex = n;
        while (swapIndex != arr.length -1 ) {
            swapIndex = arr.length -1;
            for (int i = arr.length - 1; i > n; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(i, i - 1, arr);
                    swapIndex = i;
                }
            }
            n = swapIndex;
        }
        return arr;
    }
    private void swap(int index, int i, int[] arr) {
        int tem = arr[i];
        arr[i] = arr[index];
        arr[index] = tem;
    }
}
