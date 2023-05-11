package 야근지수;

import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: works) que.add(x);
        for(int i=0; i<n; i++) que.add(que.poll()-1);
        if(que.peek() <= 0) return 0; 
        while (!que.isEmpty()) {
            int x = que.poll();
            answer += x*x; 
        }
        return answer;
    }
}