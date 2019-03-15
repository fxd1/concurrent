package com.qunar.fxd.leetcode;

import java.lang.reflect.Field;
import java.util.Objects;

public class Test {

    public static void main1(String[] args) throws Exception {
        long st =  System.currentTimeMillis();
        for (int i=0; i< 1000; i++) {
            final Field[] declaredFields = ListNode.class.getDeclaredFields();
            final ListNode listNode = new ListNode(-1);
                Object o = declaredFields[0].get(listNode);
        }

        System.out.println(System.currentTimeMillis() -st);
    }

    public static void main(String[] args) throws Exception {
        long st =  System.currentTimeMillis();
        for (int i=0; i< 1000; i++) {
            final ListNode listNode = new ListNode(-1);
            int a = listNode.val;
        }

        System.out.println(System.currentTimeMillis() -st);
    }
}
