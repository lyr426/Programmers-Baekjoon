package 연속부분수열합의개수;

import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        HashMap<Long, Integer> map = new HashMap<>();
        int[] circle = new int[len*2-1];
        for(int i=0; i<len*2-1; i++) {
            if(i<len-1){
                circle[i] = elements[i+1];
                continue;
            }
            circle[i] = elements[i-len+1];
        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len+1; j++){
                Long sum = 0L;
                for(int k=j; k<i+j; k++) {
                    sum += circle[k];
                }
                map.put(sum, 0);
            }
        }
        answer = map.size();
        return answer;
    }
}