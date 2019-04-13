package com.qunar.fxd.leetcode.linkedlist;

import com.qunar.fxd.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 *
 * 分割链表
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode root, int k) {

        int lenght = lenght(root);
        ListNode[] res =  new ListNode[k];

        int single = lenght /k;
        int mod = lenght % k;
        ListNode head=root;
        ListNode pre = root;
        for (int i=0; i<k; i++) {
           int j = mod-->0 ?single +1 : single;
            res[i] = head;
            while (head != null && j>0){
                --j;
                pre = head;
                head = head.next;
            }
            if (head != null || j==0) {
                if (pre != null) {
                    pre.next = null;
                }
            }else {
                res[i] = null;
            }
        }
        return res;
    }



    private int lenght(ListNode head){
        int len=0;
        while (head != null){
            head = head.next;
            ++len;
        }

        return len;
    }

}
