package 위장;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String[] key: clothes){
            map.put(key[1], map.getOrDefault(key[1], map.getOrDefault(key[1],0))+1); 
        }
        for(String key: map.keySet()){
            answer *= map.get(key)+1; 
        }
        return answer-1;
    }
    
}