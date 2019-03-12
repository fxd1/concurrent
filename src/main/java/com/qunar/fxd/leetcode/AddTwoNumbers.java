package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        int jinwei = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int temp = value2 + value1;
            int val = 0;
            if (jinwei > 0) {
                temp += jinwei;
            }
            if (temp >= 10) {
                val = temp % 10;
                jinwei = temp / 10;
            } else {
                val = temp;
                jinwei = 0;
            }

            ListNode listNode = new ListNode(val);
            if (head == null) {
                head = listNode;
                tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }


        if (jinwei > 0) {
            ListNode listNode = new ListNode(jinwei);
            tail.next = listNode;
        }

        return head;
    }
}
