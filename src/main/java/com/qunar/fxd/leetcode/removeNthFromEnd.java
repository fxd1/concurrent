package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummyNode = new ListNode(-1);
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        dummyNode.next = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }


}
