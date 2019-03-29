package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversalNoRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur= root;
        while (cur!= null || !stack.isEmpty()) {
            if (cur != null){
                cur = stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {

        if (root == null) {

            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
