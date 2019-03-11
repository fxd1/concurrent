package com.qunar.fxd.niuke;

/**
 *  利用  先序数组和 中序数组 重建 二叉树
 *  1. 先序数组来判定根节点
 *  2. pre[0] 在in中的位置 可以切分 左右两个数组，左边为左子树 ，右边为右子树
 *
 *  然后就可以递归切分下去
 */
public class Solution4 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0 || pre.length != in.length) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length -1);

    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {


        if (startIn > endIn || startPre > endPre) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + (i - startIn + 1), endPre, in, i + 1, endIn);
            }

        }
        return root;

    }

}
