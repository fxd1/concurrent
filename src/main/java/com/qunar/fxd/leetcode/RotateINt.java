package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * 旋转数组中：  [1,2,3,4,5,6,7]  3   输出 [5,6,7,1,2,3,4]
 *  除了暴力之外， 则将全部翻转，然后 左右 部分各自 翻转
 *  如果是旋转字符串 ，abcd  dabc  还可以 将abcd 两个拼接，然后abcdacbd 中，从d开始截取
 */
public class RotateINt {

    /**
     * 暴力 双重循环 时间复杂 O(K*N)
     * 空间复杂度 O(1)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotate1(int[] nums, int k) {

        if (k == 0){
            return;
        }
        k %= nums.length;
        int end = nums.length-1;
        swap(nums, 0, end);
        swap(nums, 0, k-1);
        swap(nums, k, end);
    }

    private void swap(int arr[], int i, int j){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            j--;
        }
    }

}
