package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        ListNode next;
        while (cur != null && (next = cur.next) != null) {
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;
        deleteDuplicates(head);

    }


}
