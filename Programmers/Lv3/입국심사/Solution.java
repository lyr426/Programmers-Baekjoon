package 입국심사;

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right =  (long) times[0] * n;
        long mid = 0;

        while(left <= right){
            long sum = 0;
            mid = left + (right - left) / 2;
            for(int time: times){
                sum += mid / time;
            }

            if(sum < n) {
                left = mid + 1;
            }else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}