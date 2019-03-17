package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class MyLinkedList {

    ListNode head =  null;
    ListNode end = null;
    int size = 0;
    public MyLinkedList() {
    }

    public int get(int index) {
        ListNode temp = head;//防止改变头
        if(head==null||size-1<index) return -1;//不存在头，以及访问的下标与长度不符合，返回-1
        int count = 0,end = 0;
        while(count<=index){//遍历找出对应的数据
            end = temp.val;
            temp = temp.next;
            count++;
        }
        return end;
    }

    public void addAtHead(int val) {
        ListNode newH = new ListNode(val);
        if(head!=null){//替换头部
            newH.next = head;
            head = newH;
        }else{//不存在头，则新建一个，并且把尾部也指向头部
            head = new ListNode(val);
            end = head;
        }
        size++;//增加长度
    }

    public void addAtTail(int val) {
        ListNode newH = new ListNode(val);
        if(end!=null){
            end.next = newH;
            end = newH;
        }else{//不存在尾，说明也不存在头，则新建一个，并且把头部也指向尾部
            end = new ListNode(val);
            head = end;
        }
        size++;//增加长度
    }

    public void addAtIndex(int index, int val) {
        if(head==null) {
            if(index>0) return;//如果链表为空，插入下标大于0，直接返回，不给插入
            head = new ListNode(val);//插入下标为0，则新增链表头，并且把尾部也指向头部
            end = head;
        }else{
            if(index>size) return;//如果插入的位置与实际长度不符合，直接返回，不给插入
            ListNode temp = head;
            ListNode newH = new ListNode(val);
            int count = 0;
            while(count<index-1){//遍历找出要替换的位置B
                temp = temp.next;
                count++;
            }
            ListNode flag = temp.next;//将位置B往后挪一位，新数据替换位置B
            temp.next = newH;
            newH.next = flag;
            if(index==size) end = newH;//如果刚好插入在最后一位，则将尾部指向新数据
        }
        size++;//增加长度
    }

    public void deleteAtIndex(int index) {
        if(index>size-1) return;//如果删除的位置与实际长度不符合，直接返回，不给删除
        ListNode temp = head;
        int count = 0;
        while(count<index-1){//遍历到要删掉的位置B的上一节点
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;//把位置B的下一节点赋给B的上一节点的next，即把位置B给删掉
        if(index==size-1) end = temp;//如果刚好删除最后一位，则将尾部指向上一位数据
        size--;//减少长度
    }


}
