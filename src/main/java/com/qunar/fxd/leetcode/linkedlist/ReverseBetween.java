package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    /**
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {


        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 0; i < m - 1; i++) {
            preNode = preNode.next;
        }

        ListNode pre = preNode.next;
        ListNode h1 = preNode.next;
        if (pre == null) {
            return head;
        }

        ListNode cur = pre.next;
        pre.next = null;

        ListNode next;
        while (m < n && cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            ++m;
        }
        preNode.next = pre;
        h1.next = cur;
        return dummy.next;
    }
}
