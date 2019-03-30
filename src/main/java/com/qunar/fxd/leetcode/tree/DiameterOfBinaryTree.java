package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/comments/
 * <p>
 * <p>
 * <p>
 * 可以将二叉树的直径转换为：二叉树的 每个节点的左右子树的高度和 的最大值。
 */
public class DiameterOfBinaryTree {


    public int diameterOfBinaryTree(TreeNode root) {


        if(root == null){
            return  0;
        }
        int arr[] = new int[1];
        deep(root,arr);
        return arr[0];
    }

    public int deep(TreeNode root, int []res){

        if(root == null){
            return 0;
        }
        int left = root.left == null ? 0 : deep(root.left,res) + 1;  //左右子树为空，返回0，否则返回值加一
        int right = root.right == null ? 0 : deep(root.right,res) + 1;
        res[0] = Math.max(res[0],left + right); //以root为根节点的直径为left + right
        return Math.max(left, right);
    }
}
