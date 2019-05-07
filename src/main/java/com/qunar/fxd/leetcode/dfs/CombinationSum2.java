package com.qunar.fxd.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 2, 1, 2};
        Arrays.sort(args);
//        combinationSum2(arr, 5);
    }

    //深度优先遍历，注意去重即可
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        dfs(listAll,list,candidates,target,0);
        return listAll;
    }
    public void dfs(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //终止条件之一，另一个为candidates[i]<=target；
        if(target == 0){
            listAll.add(tmp);
            return;
        }

        for(int i = num;i<candidates.length&&candidates[i]<=target;i++){
            ArrayList<Integer> list = new ArrayList<>(tmp);//深拷贝，否则会覆盖掉tmp;
            list.add(candidates[i]);
            dfs(listAll,list,candidates,target-candidates[i],i+1);
            //下一次循环不从重复的数字开始
            while(i<candidates.length-1 && candidates[i+1]==candidates[i]){
                i++;
            }
        }
    }
}

