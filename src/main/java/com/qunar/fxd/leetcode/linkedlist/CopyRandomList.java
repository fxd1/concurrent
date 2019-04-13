package com.qunar.fxd.leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/comments/
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 */
public class CopyRandomList {

    /**
     *
     * 1. 根据next进行克隆，并且将next添加到源节点后边
     * A -B -C  变为 A-A1-B-B1-C-C1
     * 2. 从头遍历，A1的random指针指向A的random指针的next
     * 因为next有重复，若指向自己A， 则A1就指向自己A1
     *
     * 3. 从头至尾遍历，拆分成两个链表
     * A1为head1， A1.next为 head的next
     * cur为old的游标
     * curNew为new的游标
     * curnew = head1.next;
     * cur = head;
     *
     * while(curnew != null){
     *     cur.next = curnew.next;
     *     cur = cur.next;
     *     curnew.next = cur == null ? null : cur.next;
     *     curnew = curnew.next;
     * }
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null){
            return  null;
        }

        Node cur = head;
        while (cur !=null){
            Node node = new Node();
            node.val = cur.val;
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        cur = head;

        while (cur != null){
            Node next = cur.next;
            next.random = (cur.random == null ? null :cur.random.next);
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next;
        Node newcur = newHead;
        while (newcur != null){
            cur.next = newcur.next;
            cur =cur.next;
            newcur.next = (cur == null ? null : cur.next);
            newcur =newcur.next;
        }

        return newHead;
    }
}
