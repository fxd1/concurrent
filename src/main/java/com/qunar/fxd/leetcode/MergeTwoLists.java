package com.qunar.fxd.leetcode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur = l1.val > l2.val ? l2 : l1;
        ListNode sec = l1.val > l2.val ? l1 : l2;
        ListNode temp;
        ListNode head = cur;
        while (cur.next != null) {
            int next = cur.next.val;
            if (sec.val < next) {
                temp = cur.next;
                cur.next = sec;
                sec = temp;
            }
            cur = cur.next;
        }
        cur.next = sec;
        return head;
    }

}
