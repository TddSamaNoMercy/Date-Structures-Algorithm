package com.xym.datastructure.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

//2. 两数相加
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode cur = dh;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int q = 0, r = 0;

        while (cur1 != null || cur2 != null) {

            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            r = (val1 + val2 + q) % 10;
            q = (val1 + val2 + q) / 10;

            cur.next = new ListNode(r);
            if (cur1 != null)
                cur1 = cur1.next;

            if (cur2 != null)
                cur2 = cur2.next;

            cur = cur.next;
        }
        if (q != 0) cur.next = new ListNode(1);
        return dh.next;
    }

}
