package com.qunar.fxd.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {


    /**
     *  双指针
     *
     *  1. 找到中间节点
     *  2.  分为左右两部分
     *  3. 将有半部分的 插入左半部分的间隙中
     * @param head
     */
    public void reorderList1(ListNode head) {

        if(head == null)
            return;
        ListNode p1 = head,p2 = head,middle = null;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            middle = p1;
        }
        //拆成两个链表
        p1 = head;
        if(middle == null) return;
        p2 = middle.next;
        middle.next = null;
        //反转链表
        ListNode prev = null,nextNode = p2;
        while(p2 != null) {
            nextNode = p2.next;
            p2.next = prev;
            prev = p2;
            p2 = nextNode;
        }
        p2 = prev;
        ListNode temp = p1,p1Next = null,p2Next = null;
        while(p2!= null) {
            p1Next = temp.next;
            p2Next = p2.next;
            temp.next = p2;
            temp.next.next = p1Next;
            temp = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }

        /**
         * 双端列表
         *
         * @param head
         */
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            next = queue.pollLast();
            cur.next = next;
            cur = next;
        }
        if (cur != null){
            cur.next = null;
        }


    }
}
