package com.qunar.fxd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Shuffle {

    private int origin[];

    public Shuffle(int[] nums) {
        origin = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = new int[origin.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int o : origin) {
            list.add(o);
        }
        Collections.shuffle(list);
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4};
        Shuffle shuffle = new Shuffle(arr);
        int[] shuffle1 = shuffle.shuffle();
        System.out.println(Arrays.toString(shuffle1));
        int[] reset = shuffle.reset();
        System.out.println(Arrays.toString(reset));
        int[] shuffle2 = shuffle.shuffle();
        System.out.println(Arrays.toString(shuffle2));

        int[] shuffle3 = shuffle.shuffle();
        System.out.println(Arrays.toString(shuffle3));
    }
}
