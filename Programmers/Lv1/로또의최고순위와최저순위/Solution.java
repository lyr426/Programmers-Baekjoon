package 로또의최고순위와최저순위;

import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        final int NUM = 6; 
		int[] answer = {1, 1};  
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for(int x: win_nums) {
			map.put(x, null); 
		}
		for(int i=0; i<NUM; i++) {
			if(lottos[i] == 0) {
				answer[1]++;
				if(map.size() < NUM-i) answer[0]++; 
				continue; 
			}
			if(map.containsKey(lottos[i])) {
				map.remove(lottos[i]);
				continue; 
			}
			answer[0]++;
			answer[1]++;
		}
        if(answer[0]>NUM) answer[0] = NUM;
        if(answer[1]>NUM) answer[1] = NUM; 
        return answer;
    }
}