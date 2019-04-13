package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = head;
        for (int i=0; i< n;i++){
            cur =cur.next;
        }
        ListNode fast  =cur;
        ListNode slow = dummyNode;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return dummyNode.next;
    }



}
