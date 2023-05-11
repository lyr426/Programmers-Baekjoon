package 다음큰숫자;

import java.util.*;
class Solution {
    public int countDigit(String str){
        int answer = 0;
        for(char c: str.toCharArray()) if(c == '1') answer++;
        return answer;
    }
    public int solution(int n) {
        String n_bi = Integer.toBinaryString(n);
        int cnt_n = countDigit(n_bi);
        while(countDigit(Integer.toBinaryString(++n)) != cnt_n);
        return n; 
    }
}