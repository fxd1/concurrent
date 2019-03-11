package com.qunar.fxd.niuke;

public class Solution2 {

    public String replaceSpace(StringBuffer str) {


        StringBuilder stringBuilder = new StringBuilder();
        String s = str.toString();
        char[] chars = s.toCharArray();

        for (int i=0; i< chars.length; i++){

            char ch = chars[i];
            if (ch == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


}
