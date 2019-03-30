package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res=  new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            List<Integer> temp =new ArrayList<>();
            int levelCount = queue.size();
            while (levelCount > 0){

                 root = queue.poll();
                 temp.add(root.val);
                if (root.left != null){
                    queue.addLast(root.left);
                }
                if (root.right != null){
                    queue.addLast(root.right);
                }
                --levelCount;
            }

            res.add(temp);
        }

        return res;
    }


}
