package com.xym.datastructure.sort;

public class SelectionSort implements Sort{
    public int[] sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minLeft = left;
            int maxRight = right;
            if (arr[left] > arr[right]) {
                swap(left, right, arr);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i] > arr[maxRight]) {
                    maxRight = i;
                } else if (arr[i] < arr[minLeft]) {
                    minLeft = i;
                }
            }
            swap(left,minLeft,arr);
            swap(right,maxRight,arr);
            left++;
            right--;
        }
        return arr;
    }

    private void swap(int index, int i, int[] arr) {
        int tem = arr[i];
        arr[i] = arr[index];
        arr[index] = tem;
    }

}
