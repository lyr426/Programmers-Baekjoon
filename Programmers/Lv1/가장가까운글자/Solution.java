package 가장가까운글자;

import java.util.*;
class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        HashMap<Character, Integer> map = new HashMap<>();
        char[] word = s.toCharArray();

        for(int i=0; i<len; i++) {
            answer[i] = -1;
            if(map.containsKey(word[i])){
                answer[i] = i - map.get(word[i]);
            }
            map.put(word[i], i);
        }

        return answer;
    }
}