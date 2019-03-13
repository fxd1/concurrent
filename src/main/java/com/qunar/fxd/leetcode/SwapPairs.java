package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 递归实现 ，三个指针，cur  next  nextnext
 * 递归 则 当前转换后的节点 指向 子链表的节点
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
