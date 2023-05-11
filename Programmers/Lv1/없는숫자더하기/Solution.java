package 없는숫자더하기;

import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        final int LENGTH = 9; 
        int answer = 0;
        int num = 0; 
        HashMap <Integer, Integer> map = new HashMap<>(); 
        for(int x: numbers){
            map.put(x, num++); 
        }
        for(int i=0; i<=LENGTH; i++){
            if(!map.containsKey(i)) answer+=i; 
        }
        return answer;
    }
}