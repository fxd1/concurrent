package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * 仍然是快慢指针的思想， 快指针去找到下一个 不等于 val的节点。然后将慢指针的next指向快指针节点。
 *
 * 做法 ： 遍历快指针，  判断快指针的值不等于val节点，则将慢指针next指向快指针，然后将慢指针变为快指针
 * 然后将 快指针移动一位，继续判断。若相同val，则不断移动 快指针
 *
 *
 * 此外，因为有可能 head节点就是要删除的节点。 所以可以设置一个哑节点。
 * 让慢指针先等于哑结点， 快指针从head开始遍历
 *
 *  输出 则是 哑结点的next为新的链表头节点。指向的就是第一个不为val的节点。若next为null 表示新链表为空
 *
 */
public class removeElementsList {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(0);

        ListNode pre = dummyNode;
        ListNode cur =head;

        while (cur != null){
            if (cur.val != val){
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }

        /**
         * [1,2,6,3,4,5,6]
         * 6
         * 当cur在 末尾的时候 ，pre在5位置。 cur。val == val。则 执行next导致6并没有删除掉。  仍然有5-》6
         * 所以将pre的末尾 指向null
         */
        pre.next = null;
        return dummyNode.next;
    }
}
