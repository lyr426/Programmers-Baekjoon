package 단속카메라;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, Comparator.comparingInt(o1 -> o1[0]));
        int cam = routes[0][1];
        for(int i=1; i< routes.length; i++){
            if(routes[i][0] > cam) {
                cam = routes[i][1];
                answer += 1;
                continue;
            }
            cam = Math.min(cam, routes[i][1]);
        }
        return answer;
    }
}