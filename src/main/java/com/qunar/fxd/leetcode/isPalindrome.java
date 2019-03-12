package com.qunar.fxd.leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class isPalindrome {

    public static boolean isPalindrome(int x) {

        String s = x+"";

        int left = 0;
        int right = s.length() -1;
        while (left <= right){

             char c = s.charAt(left);
             char c1 = s.charAt(right);
             if (c == c1){
                 ++left;
                 --right;
             }else {
                 return false;
             }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }


}
