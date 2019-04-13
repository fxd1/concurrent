package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class HasCycle {


    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null){
            return  false;
        }
        ListNode slow = head;
        ListNode fast =  head.next;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



}