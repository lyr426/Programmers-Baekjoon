package 기능개발;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int len = progresses.length;
        int cur=0;
        while (cur < len){
            int complete = 0;
            for(int i=cur; i<len; i++) progresses[i] += speeds[i];
            if(progresses[cur] >= 100){
                while(cur<len && progresses[cur] >= 100) {
                    complete++;
                    cur++;
                }
                list.add(complete);
            }
        }
        answer = new int[list.size()]; 
        int i=0; 
        for(int x:list) answer[i++] = x; 
        return answer;
    }
}