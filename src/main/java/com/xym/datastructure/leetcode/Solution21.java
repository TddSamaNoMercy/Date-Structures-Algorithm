package com.xym.datastructure.leetcode;

public class Solution21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode prev = dh;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dh.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode res = new Solution21().mergeTwoLists(l1, l2);
        System.out.println(" ");
    }
}
