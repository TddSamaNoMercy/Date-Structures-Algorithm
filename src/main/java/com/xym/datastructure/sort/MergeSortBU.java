package com.xym.datastructure.sort;

public class MergeSortBU implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size += size) {
            for (int i = 0; i < n; i += size << 1) {
                if (arr[i + size - 1] > arr[i + size])
                    merge(i, i + size - 1, Math.min(i + size * 2 - 1, n - 1), arr);
            }
        }
        return new int[0];
    }

    private void merge(int l, int mid, int r, int[] arr) {
        int[] aux = new int[r - l + 1];
        System.arraycopy(arr, l, aux, 0, r - l + 1);
        int i = 0;
        int j = mid - l + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid - l) {
                arr[k] = aux[j];
                j++;
            } else if (j > r - l) {
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
