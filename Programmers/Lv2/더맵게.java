import java.util.*; 
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(); 
        for(int x: scoville) que.add(x); 
        
        while(que.peek()<K && que.size() >= 2){
            int first = que.remove(); 
            int second = que.remove();
            que.add(first + (second*2));
            answer++; 
        }
        if(que.peek() < K) return -1; 
        return answer; 
    }
}