package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 *
 */
public class RotateRight {


    /**
     * 循环链表，将尾部接头部
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }

        cur.next = head;

        int x = len - (k % len);

        cur =head;
        for (int i=0; i< x-1; i++){
            cur = cur.next;
        }

        head = cur.next;
        cur.next = null;
        return head;

    }


}
