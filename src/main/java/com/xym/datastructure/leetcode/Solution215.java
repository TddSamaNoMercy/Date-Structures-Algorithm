package com.xym.datastructure.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

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

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4, 4};
        System.out.println(new Solution215().findKthLargest(arr, 4));
    }
}
