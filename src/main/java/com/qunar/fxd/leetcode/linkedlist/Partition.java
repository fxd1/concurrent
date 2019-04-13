package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Partition {


    public ListNode partition(ListNode head, int x) {
        ListNode leftdummy = new ListNode(-1);
        ListNode rightdummy = new ListNode(-1);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightdummy.next;
        right.next = null;
        return leftdummy.next;
    }


}
