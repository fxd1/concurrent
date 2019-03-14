package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-list/submissions/
 *
 * 旋转链表  相当于  说是循环旋转，但其实本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
 * 先找到 链表的长度 ，然后求得 旋转次数  。。  取模，并且把尾部节点指向 头结点
 *
 * 然后从头到尾的
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }
        //改成循环链表
         cur.next = head;
        k = len - (k % len);
        cur = head;
        for (int i = 0; i < k-1 ; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;

    }


}
