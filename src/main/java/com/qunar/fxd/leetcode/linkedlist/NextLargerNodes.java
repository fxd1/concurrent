package com.qunar.fxd.leetcode.linkedlist;

import com.google.common.base.Joiner;
import com.qunar.fxd.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 */
public class NextLargerNodes {
    public static final Joiner CONNECT_FLIGHT_JOINER = Joiner.on('/').skipNulls();


    public int[] nextLargerNodes(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new int[]{0};
        }
        Stack<ListNode> stack = new Stack<>();

        Map<ListNode, Integer> map = new HashMap<>();

        ListNode cur = head;
        int count = 0;
        while (head != null) {

            int value = head.val;
            while (!stack.isEmpty() && stack.peek().val < value) {
                map.put(stack.pop(), value);
            }
            stack.push(head);
            ++count;
            head = head.next;
        }
        int res[] = new int[count];
        for (int i = 0; i < count; i++) {

            res[i] = map.getOrDefault(cur, 0);
        }
        return res;
    }


    /**
     * 递归
     * 翻转链表
     */
    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    /**
     * 递归
     * 翻转链表
     */
    public ListNode reverseNoRec(ListNode head) {
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
