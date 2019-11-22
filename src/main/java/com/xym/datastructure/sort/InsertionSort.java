package com.xym.datastructure.sort;

//插入排序对于近乎有序的数组速度很快
public class InsertionSort implements Sort {
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int num = arr[i];
            for (; j > 0 && arr[j - 1] > num; j--) {
                    arr[j] = arr[j - 1];
            }

            arr[j] = num;
        }
        return arr;
    }

}
