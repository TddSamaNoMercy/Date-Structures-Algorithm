package com.xym.datastructure.sort;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;

public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        heapify(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(i, 0, arr);
            shiftdown(0, arr, i);
        }
        return arr;
    }

    private void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void heapify(int[] arr, int length) {
        for (int k = (length - 2) >> 1; k >= 0; k--) {
            shiftdown(k, arr, length);
        }
    }

    private void shiftdown(int k, int[] arr, int length) {
        int v = arr[k];
        while (2 * k + 1 <= length - 1) {
            int j = 2 * k + 1;
            if (j + 1 <= length - 1 && arr[j+1] > arr[j]) {
                j++;
            }
            if (v > arr[j]) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = v;
    }
}
