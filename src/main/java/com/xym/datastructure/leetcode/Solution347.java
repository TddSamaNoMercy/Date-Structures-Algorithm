package com.xym.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(new Solution347().topKFrequent(a, 2));
    }
}