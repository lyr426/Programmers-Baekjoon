package 문자열을내림차순으로배치하기;

import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = ""; 
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder()); 
        for(String ss: str) answer+=ss;
        return answer; 
    }
}