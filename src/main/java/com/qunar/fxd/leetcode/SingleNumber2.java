package com.qunar.fxd.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumber2 {

    public static int singleNumber(int[] nums) {
        // 对每一位单独统计出现1的次数, 如果出现的次数不能整除3说明唯一存在的数在这一位上为1, 时间复杂度O(32N)

        int res= 0;
        for (int i=0; i<32; i++){

            int bitNums = 0;
            int bit = 1 <<i;
            for (int n: nums){
                if ((n&bit) !=0){
                    bitNums ++;
                }
            }

            if (bitNums % 3 !=0){
                res |= bit;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int arr[] = new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(singleNumber(arr));
    }
}

