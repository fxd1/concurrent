package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {


    /**
     * 插入排序的思想
     * 合理利用 哑结点
     * 因为头结点前也会进行替换
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = head;
        while (cur.next != null){
            if (cur.val< cur.next.val){
                cur= cur.next;
            }else {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                ListNode pre = dummyNode;
                while (pre.next.val < temp.val){
                        pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummyNode.next;
    }




}
