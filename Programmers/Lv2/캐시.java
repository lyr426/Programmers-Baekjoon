import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        for(String str: cities){
            str = str.toLowerCase(Locale.ROOT);
            if(!cache.isEmpty() && cache.contains(str)){
                answer+=1;
                cache.remove(str);
                cache.add(str);
                continue;
            }
            cache.add(str);
            if(cache.size()>cacheSize) cache.remove(0);
            answer+=5;
        }
        return answer;
    }
}