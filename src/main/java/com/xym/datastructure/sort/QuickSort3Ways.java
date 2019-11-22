package com.xym.datastructure.sort;

import java.util.Random;

public class QuickSort3Ways implements Sort {
    Random random = new Random();
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        quickSort(0,n-1,arr);
        return arr;
    }

    private void quickSort(int l, int r, int[] arr) {
        if (l>=r) return;

        int index = random.nextInt(r-l+1) + l;
        swap(index,l,arr);
        int v = arr[l];

        int lt = l,gt = r + 1,i = l+ 1;

        while(i<gt){
            if (arr[i] < v){
                swap(lt + 1,i,arr);
                lt++;
                i++;
            }else if (arr[i] > v) {
                swap(gt-1,i,arr);
                gt--;
            }else {
                i++;
            }
        }
        swap(l,lt,arr);

        quickSort(l,lt-1,arr);
        quickSort(gt,r,arr);

    }

    private void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
