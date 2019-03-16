package com.qunar.fxd.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {


    /**
     *
     *  假定 头节点 到 入环节点的 距离为 a
     *  快慢指针相遇的点  距离 入环节点 顺时针的距离是 b
     *
     *  相遇节点到入环节点的距离 是c
     *   b+c 为环的距离
     *
     *   快指针是慢指针的2倍
     *   第一次相遇的慢指针的距离是  a+b
     *   那么快指针的距离是  2 * (a +b)
     *   同时快指针的之所以相遇 是因为比慢指针多走一圈
     *   也就是多了一个  环的距离   b +c
     *  所以 2* （a+b)= a+b + b+c   也就是   a = c
     *  双指针
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode p = head, p2 = head;
        boolean hasCycle = false;
        while (p2 != null && p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }

        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return q;
        } else
            return null;

    }

        /**
         * 哈希表
         * @param head
         * @return
         */
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while (head != null){

            if (!set.contains(head)){
                set.add(head);
                head = head.next;

            }else {
                return head;
            }
        }

        return head;
    }
}
