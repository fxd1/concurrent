package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal11 {



    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackValue = new Stack<>();
        while (root == null || !stack.isEmpty()){
            if (root != null){
                stackValue.push(root.val);
                stack.push(root);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }
        }
        while (!stackValue.isEmpty()){
            res.add(stackValue.pop());
        }
        return res;
    }
}
