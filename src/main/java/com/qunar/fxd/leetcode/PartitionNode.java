package com.qunar.fxd.leetcode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * 思想： 由两个哑结点分表表示小于x的链表 和大于等于x的链表
 * 遍历当前遍历 ，归类到 大小链表中，然后用小链表的末尾去连接 大连表的头部
 *
 */
public class PartitionNode {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(-1);
        ListNode right = rightHead;
        while (head != null){
            if (head.val < x){
                left.next = head;
                left = left.next;
            }else {
                right.next = head;
                right = right.next;
            }

            head = head.next;
        }
        //要将 右边的链表 断开 ，防止产生循环
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;

    }


}
