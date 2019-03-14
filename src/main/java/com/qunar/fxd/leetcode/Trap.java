package com.qunar.fxd.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * 思想：  先找到 最高点 的下标
 *  然后分为两部门， 从左到最高点， 从右到最高点 两部分进行计算
 *
 *  左边的任何一个都比最高点要小，然后 先从 左边第一个开始，作为lmax，然后与相邻的第二个相比较，
 *  若第二个小，说明有凹槽， 则第一个减 第二个 为 积水的面积。 若第二个大于第一个，则将第二个作为lmax。继续找
 *  下一个。如果是递增的，没有凹槽，那么左边则没有积水处。
 *
 *  右侧 同理也是如此。。
 *
 *  最后相加
 *
 */
public class Trap {

    public static int trap(int[] height) {


        int index = 0;
        int max = 0;
        for (int i=0; i< height.length; i++){
            if (max < height[i]){
                max = height[i];
                index = i;
            }
        }

        int res = 0;
        int l = 0;
        for (int left=0; left < index; left ++){

            if (l> height[left] ){
                res += l - height[left];
            }else {
                l = height[left];
            }
        }

        int r = 0;
        for (int right = height.length -1; right > index; right --){
            if (r > height[right]){
                res += r - height[right];
            }else {
                r = height[right];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(arr));
    }

}


