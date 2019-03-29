package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list  =new ArrayList<>();
        InOrder(root,list, k);
        return list.get(k-1);
    }


    public void InOrder(TreeNode root, List<Integer> list, int k){
        if (root == null){
            return;
        }
        InOrder(root.left, list, k);
        if (list.size() <k){
            list.add(root.val);
        }else {
            return;
        }
        InOrder(root.right, list, k);
    }




}
