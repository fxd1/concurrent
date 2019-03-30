package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

/**
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left =  minDepth(root.left);
        int right =  minDepth(root.right);

        if (left == 0 && right != 0){
            return right +1;
        }else if (left!=0 && right ==0){
            return left+1;
        }
        return Math.min(left, right) +1;
    }


}
