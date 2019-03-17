package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLis {


    public ListNode oddEvenList(ListNode head) {


        if (head == null || head.next == null){
            return head;
        }


        ListNode left = head;
        ListNode cur = head.next;
        ListNode rightDummyNode =  new ListNode(-1);
        ListNode right =  rightDummyNode;

        int count = 0;
        while (cur != null){
            if (count % 2 != 0) {
                left.next = cur;
                left = left.next;
            }else {
                right.next = cur;
                right = right.next;
            }
            ++count;
            cur = cur.next;
        }

        right.next = null;
        left.next = rightDummyNode.next;
        rightDummyNode.next =  null;

        return head;

    }



}
