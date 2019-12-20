package com.xym.datastructure.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int res = -1;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }


}
//使用快排
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return findKthLargest(0,n-1,nums,n - k);
    }

    private int findKthLargest(int l, int r, int[] arr, int pos) {
        if (l == r) return arr[l];
        Random random = new Random();
        int index = random.nextInt(r - l + 1);
        int val = arr[index + l];
        int lr = l,gr = r+1;
        for (int i = l; i < gr;) {
            if (arr[i] == val) {
                i++;
            } else if (arr[i] < val) {
                swap(lr++,i++,arr);
            } else {
                swap(--gr,i,arr);
            }
        }
        if (pos < gr && pos >= lr) return val;
        else if (pos >= gr) return findKthLargest(gr,r,arr,pos);
        else return findKthLargest(l,lr - 1,arr,pos);
    }

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(new Solution().findKthLargest(arr, 2));
    }
}
