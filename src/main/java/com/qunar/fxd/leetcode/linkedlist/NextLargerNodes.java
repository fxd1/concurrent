package com.qunar.fxd.leetcode.linkedlist;

import com.google.common.base.Joiner;
import com.qunar.fxd.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 */
public class NextLargerNodes {
    public static final Joiner CONNECT_FLIGHT_JOINER = Joiner.on('/').skipNulls();


    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Map<ListNode , Integer> hashMap = new HashMap<>();
        int i = 0;
        ListNode h = head;
        while (h != null) {
            while (!stack.isEmpty()&&stack.peek().val < h.val) {
                hashMap.put(stack.pop(), h.val);
            }
            stack.push(h);
            h = h.next;
            i++;
        }
        int[] ints = new int[i];
        for (int j = 0; j < i; j++) {
            ints[j] = hashMap.getOrDefault(head,0);
            head = head.next;
        }
        return ints;
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
