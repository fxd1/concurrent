package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversalNoRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
             TreeNode pop = stack.pop();
             list.add(pop.val);
             if (pop.left != null){
                 stack.push(pop.left);
             }else {
                 if (pop.right != null) {
                     stack.push(pop.right);
                 }
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
