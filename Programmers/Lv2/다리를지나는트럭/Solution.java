package 다리를지나는트럭;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
        int size = 0;
        int cur_weight = 0;
        int cur_length = 0;
        while (size != truck_weights.length){
            answer++;
            if(cur_length == bridge_length){
                cur_weight -= bridge.removeFirst();
                cur_length--;
            }
            if(cur_weight+truck_weights[size] <= weight && cur_length < bridge_length){
                cur_weight+=truck_weights[size];
                cur_length++;
                bridge.add(truck_weights[size++]);
                continue;
            }
            bridge.add(0);
            cur_length++;
        }
        return answer+bridge_length;
    }
}