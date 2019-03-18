package com.qunar.fxd.leetcode.array;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class FindErrorNums {



    public int[] findErrorNums(int[] nums) {


        int sum  =0;
        int total  =nums.length;
        int hash [] = new int[10000];
        int duplicate  = 0;
        for (int i=0; i<nums.length; i++){
            total +=i;
            sum += nums[i];
            hash[nums[i]]++;
            if (hash[nums[i]] > 1){
                duplicate = nums[i];
            }
        }

        int miss  =total - (sum - duplicate);

        return new int[]{duplicate, miss};
    }


}
