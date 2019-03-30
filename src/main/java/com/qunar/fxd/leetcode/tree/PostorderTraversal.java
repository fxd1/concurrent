package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postorderRec(root, res);

        return res;
    }

    /**
     *
     * l
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderNoRec(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackValue = new Stack<>();
        while(root != null || !stack.isEmpty()){
            //类似于 先序 根右左   然后再反转
            if (root == null) {
                root = stack.pop();
                root = root.left;
            }
            else{
                stack.push(root);
                stackValue.push(root.val);
                root = root.right;
            }
        }
        while (!stackValue.isEmpty()){
            ans.add(stackValue.pop());
        }
        return ans;

    }

    public void postorderRec(TreeNode root, List<Integer> res) {

        if (root == null) {
            return;
        }
        postorderRec(root.left, res);
        postorderRec(root.right, res);
        res.add(root.val);
    }


}
