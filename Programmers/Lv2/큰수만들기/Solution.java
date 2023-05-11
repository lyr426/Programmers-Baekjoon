package 큰수만들기;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();
        sb.append(number);
        int start = 0;
        for(int i=0; i<k; i++){
            int index = start;
            if(sb.charAt(0) == '9' && sb.charAt(index+1) == '9') start++;
            while (index<sb.length()-i-1){
                if(sb.charAt(index) < sb.charAt(index+1)) break;
                index++;
            }
            sb.deleteCharAt(index);
        }
        return String.valueOf(sb);
    }
}