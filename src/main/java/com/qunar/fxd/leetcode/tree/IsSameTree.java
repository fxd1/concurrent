package com.qunar.fxd.leetcode.tree;


import com.qunar.fxd.niuke.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 *
 *
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
