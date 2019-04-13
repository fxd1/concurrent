package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {



    /**
     * 将链表各自翻转， 然后进行计算之后，然后再进一步进行翻转
     * @param l1
     * @param l2
     * @return
     */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode p = reverse(l1);
        ListNode q = reverse(l2);
        int carry = 0;
        ListNode cur = dummy;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return reverse(dummy.next);
    }


    private ListNode reverse(ListNode root){

        if (root == null || root.next == null){
            return root;
        }


        ListNode reverse = reverse(root.next);

        root.next.next =  root;
        root.next = null;
        return reverse;
    }


}
