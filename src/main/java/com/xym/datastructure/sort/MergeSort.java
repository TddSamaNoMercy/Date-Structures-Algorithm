package com.xym.datastructure.sort;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        mergeSort(0, n - 1, arr,aux);
        return arr;
    }

    private void mergeSort(int l, int r, int[] arr,int[] aux) {
        if (r - l <= 15) {
            insertionSort(l,r,arr);
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(l, mid, arr,aux);
        mergeSort(mid + 1, r, arr,aux);
        if (arr[mid] > arr[mid + 1])
            merge(l, r, mid, arr,aux);
    }

    private void insertionSort(int l, int r, int[] arr) {
        for (int i = l + 1; i <= r; i++) {
            int num = arr[i];
            int j = i;
            for (; j > l && arr[j-1] > num; j++) {
                arr[j] = arr[j-1];
            }
            arr[j] = num;
        }
    }

    private void merge(int l, int r, int mid, int[] arr,int[] aux) {

        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            //使用分支时注意要包含所有情况
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }
    }
}
