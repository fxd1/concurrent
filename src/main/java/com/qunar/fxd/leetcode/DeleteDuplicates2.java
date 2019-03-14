package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
 *
 * 使用 三个指针，
 * 建立一个哑节点，，减少了不必要的判断。。比如 head节点就是要删除的重复的节点
 * 然后将cur指向 head，进行遍历
 * 循环判断 临近两个节点是否相等 ，知道找到不相等的那个节点 作为next节点。
 * 将pre的next指向 next节点
 *
 *
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
      ListNode next ;
        while (cur != null){
            next = cur.next;
            int val  =cur.val;
            while (next!= null && next.val == val){
                next = next.next;
            }
            /*
             需要判断，如果next就是临近节点，则不能讲前节点指向next节点，会将cur节点误删除掉
             */
            if (cur.next == next){
                pre = cur;
                cur = next;
            }else {
                pre.next = next;
                cur = next;
            }
        }
        return dummyHead.next;

    }


}
