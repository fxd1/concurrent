package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int height(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }


}