package com.qunar.fxd.leetcode;

public class DeleteNode {

    public void deleteNode(ListNode node) {

        ListNode cur = node;

        ListNode next = cur.next;

        cur.val = next.val;

        cur.next = next.next;
    }
}
