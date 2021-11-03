import java.util.*; 
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int x: nums) map.put(x, map.getOrDefault(x, 0)+1); 
        if(map.size() >= len) return len; 
        return map.size();
    }
}