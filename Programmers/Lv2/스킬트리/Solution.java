package 스킬트리;

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(int i=0; i<skill.length(); i++) map.put(skill.charAt(i), i); 
    
        for(String str:skill_trees){
            int level = 0;
            for(char c: str.toCharArray()){
                if(!map.containsKey(c)) continue; 
                if(level < map.get(c)){
                    answer--; 
                    break; 
                }
                level++; 
            }
            answer++; 
        }
        return answer;
    }

}