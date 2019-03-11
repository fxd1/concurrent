package com.qunar.fxd.niuke;


import java.util.Collections;

import java.util.ArrayList;
public class Solution3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode p=listNode;
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> newlist=new ArrayList<Integer>();
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }
        Collections.reverse(list);
        return list;
    }

}
