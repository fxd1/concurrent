package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortLinkedList {

    /**
     * 归并思想
     * 如何找中间节点 快慢指针
     * 将两个有序的链表合并成一个有序链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
         ListNode l = sortList(head);
         ListNode r = sortList(slow);
        return merge(l, r);

    }

    private ListNode merge(ListNode left, ListNode right) {

        if (left == null && right == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummyNode.next;
    }
}
