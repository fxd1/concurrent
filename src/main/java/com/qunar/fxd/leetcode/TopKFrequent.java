package com.qunar.fxd.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) +1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()){
            if (heap.size() < k){
                heap.offer(entry);
            }else {
                if (heap.peek().getValue() < entry.getValue()){
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
         List<Integer> res = new ArrayList<>();
        for (int i=0; i<k;i++){
            res.add(heap.poll().getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int []{1,1,1,2,2,3,3,3,3};
        System.out.println(topKFrequent(arr, 2));
    }

}
