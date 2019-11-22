package com.xym.datastructure.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//349. 两个数组的交集
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i))
                set1.add(i);
        }
        int[] res = new int[set1.size()];
        Iterator iterator = set1.iterator();
        int i = 0;
        while (iterator.hasNext() && i < set.size()) {
            res[i] = (int) iterator.next();
            i++;
        }
        return res;
    }
}