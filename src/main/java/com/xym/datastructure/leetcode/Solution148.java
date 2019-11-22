package com.xym.datastructure.leetcode;


class Solution148 {

    public ListNode sortList(ListNode head) {
        //得到链表长度
        int n = 0;
        ListNode dup = head;
        while (dup != null) {
            n++;
            dup = dup.next;
        }

        //dh:用于返回的虚拟头节点;cur:用于遍历当前需要归并的链表；newHead:下一个需要归并的链表头；
        //lh、rh:用于合并的左右两个链表
        ListNode dh = new ListNode(-1);
        dh.next = head;

        for (int sz = 1; sz < n; sz += sz) {
            ListNode pre = dh;
            ListNode newHead = dh.next;
            while (true) {
                ListNode cur = newHead;
                ListNode lh = cur;
                for (int i = 0; i < sz - 1 && cur != null; i++) cur = cur.next;
                if (cur == null || cur.next == null) {
                    pre.next = lh;
                    break;
                }
                ListNode rh = cur.next;
                cur.next = null;
                cur = rh;
                for (int i = 0; i < sz - 1 && cur != null; i++) cur = cur.next;
                if (cur == null) {
                    pre.next = mergeTwoList(lh, rh);
                    break;
                }
                newHead = cur.next;
                cur.next = null;
                pre.next = mergeTwoList(lh, rh);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dh.next;
    }

    //    public ListNode sortList(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//        ListNode quick = head.next, slow = head;
//
//        while (quick!=null && quick.next!=null){
//            quick = quick.next.next;
//            slow = slow.next;
//        }
//        ListNode temp = slow.next;
//        slow.next = null;
//        head = sortList(head);
//        temp = sortList(temp);
//
//        return mergeTwoList(head,temp);
//
//    }
    //合并两个链表
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
        ListNode l = Util.generateListByArr(new int[]{1, 4, 6, 5, 7});
        ListNode l1 = new Solution148().sortList(l);
        System.out.println("");
    }
}
