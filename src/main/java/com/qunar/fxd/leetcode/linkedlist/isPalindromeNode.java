package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class isPalindromeNode {

    /**
     * 1  找mid 节点
     * 2. 反转 后半部分 链表
     * 3. 将后半部分链表进行反转
     * 4. 进行 迭代比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = pre.next;
        pre.next = null;
        ListNode reverse = reverse(right);

        while (head != null && reverse != null){
            if (head.val == reverse.val){
                head = head.next;
                reverse = reverse.next;
            }else {
                return false;
            }
        }
        if (head != null && head.next == null){
            return  true;
        }

        if (reverse != null && reverse.next == null){
            return true;
        }

        if (reverse == null && head == null){
            return true;
        }
        return false;
    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }

        return head;
    }


}
