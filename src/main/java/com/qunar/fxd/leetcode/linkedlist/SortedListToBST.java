package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;
import com.qunar.fxd.niuke.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 *
 *
 */
public class SortedListToBST {

    /**
     * 快慢指针找到中间值
     *
     * 中序遍历的 逆向构造树
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode pre = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;//断开
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }


}
