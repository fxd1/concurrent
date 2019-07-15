package com.qunar.fxd.google;

import com.qunar.fxd.leetcode.ListNode;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Solution2 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy= new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        int sum  =0;
        while (l1!= null && l2 != null) {
            sum   = l1.val + l2.val + carry;
            carry = sum /10 ;
            cur.next  = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        sum = 0;
        while (l1 != null){
            sum = l1.val+ carry;
            carry = sum /10 ;
            cur.next  = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null){
            sum = l2.val+ carry;
            carry = sum /10 ;
            cur.next  = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }

        // 特别注意，  如果 l1  l2长度一样，但是最后产生一位进位， 则需要new和一个新的节点
        if (carry != 0){
            cur.next  = new ListNode(carry);

        }
        return dummy.next;
    }

}
