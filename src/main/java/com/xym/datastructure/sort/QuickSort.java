package com.xym.datastructure.sort;

import java.util.Random;

public class QuickSort implements Sort {
    Random random = new Random();

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        quickSort(0, n - 1, arr);
        return arr;
    }

    private void quickSort(int l, int r, int[] arr) {
        if (l >= r) return;
        int pos = partition(l, r, arr);
        quickSort(l, pos - 1, arr);
        quickSort(pos + 1, r, arr);
    }

    private int partition(int l, int r, int[] arr) {
        int index = random.nextInt(r - l + 1) + l;
        swap(l, index, arr);
        int v = arr[l];
        int i = l + 1, j = r + 1;
        while (true) {
            while (i <= r && v > arr[i]) i++;
            while (j > l && v < arr[j - 1]) j--;
            if (i >= j) break;
            swap(i, j - 1, arr);
            j--;
            i++;
        }
        swap(j - 1, l, arr);
        return j - 1;
    }

//    private int partition(int l, int r, int[] arr) {
//        int index = random.nextInt(r - l + 1) + l;
//        swap(l, index, arr);
//        int v = arr[l];
//        //[l+1,...,j]区间的值<v,[j+1,...,i)>v
//        int j = l;
//        for (int i = l + 1; i <= r; i++) {
//            if (arr[i] < v) {
//                swap(j+1,i,arr);
//                j++;
//            }
//        }
//        swap(l, j, arr);
//
//        return j;
//    }

    private void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
