package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseList2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m == n){
            return head;
        }
        ListNode dummyNode = new ListNode(-2);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 找到 m节点的前一节点
        for(int i=0; i<m-1;i++){
            pre = pre.next;
        }

        //链表全旋转一致   三个指针，  子链表的头结点的next设置为next
        // 将子链表旋转  然后pre的.next指向新的子链表 头节点  ，子链表的尾部节点其实是pre原先的next节点，指向子链表后的链表的头结点
        ListNode cur = pre.next;
        ListNode next = cur.next;
        ListNode nextnext;
        cur.next = null;
        while (next != null && m <n){
            nextnext = next.next;
            next.next = cur;
            cur = next;
            next = nextnext;
            ++m;
        }
        pre.next.next = next;
        pre.next = cur;

        return dummyNode.next;
    }



}
