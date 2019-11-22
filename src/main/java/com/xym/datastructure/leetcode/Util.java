package com.xym.datastructure.leetcode;

public class Util {
    public static ListNode generateListByArr(int[] arr) {
        int n = arr.length;
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        for (int i = 0; i < n; i++) {
            prev.next = new ListNode(arr[i]);
            prev = prev.next;
        }
        return dummyHead.next;
    }
}
