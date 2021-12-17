import java.util.*; 
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>(); 
        
        for(String str: participant){
            map.put(str, map.getOrDefault(str,0)+1); 
        }
        for(String str: completion){
            if(map.containsKey(str)){
                if(map.get(str) > 1){
                    map.put(str, map.get(str)-1); 
                    continue; 
                }
                map.remove(str); 
            }  
        }
        for(String str: map.keySet()) return str; 
        return ""; 
    }
}