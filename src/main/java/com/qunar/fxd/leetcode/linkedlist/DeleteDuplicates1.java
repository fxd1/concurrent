package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

public class DeleteDuplicates1 {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy  =new ListNode(-1);
        dummy.next = head;
        ListNode pre =  dummy;
        ListNode temp;
        ListNode cur =  head;
        while (cur != null && cur.next != null){

            temp = cur;
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (cur != temp){
                pre.next = cur.next;
            }else {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
