package 두큐합같게만들기;

import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0L;
        long sum2 = 0L;
        int len = queue1.length;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for(int i=0; i<len; i++) {
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        if((sum1 + sum2)%2 != 0 ){
            return -1;
        }

        while(sum1 != sum2 && answer <= len*3){
            answer += 1;
            if(sum1>sum2) {
                int num = que1.poll();
                sum1 -= num;
                sum2 += num;
                que2.add(num);
                continue;
            }
            int num = que2.poll();
            sum2 -= num;
            sum1 += num;
            que1.add(num);
        }
        if(answer >= len * 3){
            answer = -1;
        }
        return answer;
    }
}