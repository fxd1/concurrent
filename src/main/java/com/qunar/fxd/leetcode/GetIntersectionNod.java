package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNod {


    /**
     * 求两个 链表的 交点
     *  将 A 和B  分别 进行遍历， 最短的先到达末尾，然后指向 另一个链表的表头。
     *  假定 A长 B短
     *  因为另一个表长，所以还没有到达末尾， A B链表的差距正好是 未走到末尾的距离
     *  所以 指向A长的表的头部，重新开始走，当A的原先指针走到末尾的时候 然后重新指向B的表头
     *
     *  这个时候 B的表头 和A的新指针 没有距离之差。 同时走，若有交点就是有，没有则同时遍历到null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

}
