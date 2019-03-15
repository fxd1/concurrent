package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode reverseListBack(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode node = reverseListBack(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

        /**
         * 核心思想  两个指针
         * 当前指针cur  和next指针
         * 先判断极端情况  当只有一个节点 或者 空节点的时候
         *
         * cur指向第二个节点，然后head的next指向空
         * cur的next指向第三个节点
         *
         * 然后让cur的next指向head， 然后将head指向 cur作为头， cur指向next进行迭代
         * @param head
         * @return
         */
    public ListNode reverseList(ListNode head) {

        if (head == null|| head.next == null){

            return head;
        }
        ListNode cur = head.next;
        ListNode next;
        head.next = null;

        while (cur != null){
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }

        return head;
    }


}
