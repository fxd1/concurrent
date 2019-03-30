package com.qunar.fxd.leetcode.tree;

import com.qunar.fxd.niuke.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * <p>
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 */
public class ConstructFromPrePost {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        int len = pre.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) return root;

        int L = 0;
        for (int i = 0; i < len; ++i)
            if (post[i] == pre[1])
                L = i+1;

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, len), Arrays.copyOfRange(post, L, len - 1));

        return root;
    }


}
