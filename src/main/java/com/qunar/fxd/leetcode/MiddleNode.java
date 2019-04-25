package com.qunar.fxd.leetcode;

/**
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 *
 *
 */
public class MiddleNode {


    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;


        while ( fast != null && fast.next != null){
            fast =fast.next.next;
            slow = slow.next;
        }


        return slow;

    }


}
