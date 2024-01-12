package 귤고르기;
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x: tangerine) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        List<Integer> count = new LinkedList<>(map.values());
        Collections.sort(count, Collections.reverseOrder());

        while(k > 0) {
            k -= count.get(answer);
            answer += 1;
        }

        return answer;
    }
}