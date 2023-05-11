package 프린터;

import java.util.*;

class Pair{
    int pri, loc;
    Pair(int pri, int loc){
        this.pri = pri;
        this.loc = loc;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 1;
        Queue<Pair> que = new LinkedList<>();
        PriorityQueue<Integer> priQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            que.add(new Pair(priorities[i], i));
            priQ.add(priorities[i]);
        }

        while(!priQ.isEmpty()){
            int max = priQ.poll();
            while (que.peek().pri < max) {
                Pair p = que.poll();
                que.add(p);
            }
            if(que.peek().loc == location) return answer;
            que.poll();
            answer++; 
        }

        return answer;
    }
}