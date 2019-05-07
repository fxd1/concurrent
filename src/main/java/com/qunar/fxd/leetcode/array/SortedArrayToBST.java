package com.qunar.fxd.leetcode.array;

import com.qunar.fxd.niuke.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedArrayToBST {

    /**
     * 有序的数组就是一个中序遍历 左中右的结果， 所以每一次取中间的节点为根节点，左边都小于该节点
     * 右边都大于该节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mod = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mod]);
        node.left = buildTree(nums, l, mod - 1);
        node.right = buildTree(nums, mod + 1, r);
        return node;
    }

}
