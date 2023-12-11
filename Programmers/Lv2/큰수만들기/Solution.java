package 큰수만들기;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        int cnt = 0;
        int idx = 0;
        while( cnt < k && idx <= sb.length()-2){ // cnt가 k와 같아지거나, idx 가 sb의 사이즈와 같아진다면
            if(sb.charAt(idx)<sb.charAt(idx+1)){
                sb.deleteCharAt(idx);
                cnt += 1;
                if(idx > 0 ){
                    idx -= 1;
                }
                continue;
            }
            idx += 1;
        }

        if(cnt < k){
            int remain = k - cnt;
            sb.delete(sb.length()-remain, sb.length());
        }

        return String.valueOf(sb);
    }
}