package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversalNoRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!= null || !stack.isEmpty()) {
            if (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        preOrder(root, list);

        return list;
    }


    public void preOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

}
