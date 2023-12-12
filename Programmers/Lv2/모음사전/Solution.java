package 모음사전;
import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        int curNum = 1;
        int len = word.length();
        char[] charWord = word.toCharArray();
        char[] values = {'A', 'E', 'I', 'O', 'U'};
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<5; i++) {
            map.put(values[i], i);
        }


        for(int i=4; i>=0; i--){
            if(i < len){
                int n = map.get(charWord[i]);
                answer += (curNum*n)+1;
            }
            curNum = (curNum * 5) + 1;
        }

        return answer;
    }
}