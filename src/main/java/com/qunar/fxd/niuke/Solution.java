package com.qunar.fxd.niuke;

public class Solution {

    public boolean Find(int target, int [][] array) {
        if (array.length <=0){
            return false;
        }
        int col = array[0].length;
        int row = array.length;
        for (int i=0;i< row; i++){
            for (int j=0; j< col; j++){
                if (array[i][j] > target){
                    break;
                }else if (array[i][j] == target){
                    return true;
                }
            }
        }

        return false;

    }
}
