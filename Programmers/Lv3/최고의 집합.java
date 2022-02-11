class Solution {
    public int[] solution(int n, int s) {
        if(s/n < 1) {
            int[] answer = {-1};
            return answer; 
        }
        int[] answer = new int[n]; 
        int num = s/n; 
        for(int i=0; i<n; i++) answer[i] = num; 
        for(int i=0; i<s%n; i++) answer[n-i-1]++; 
        
        return answer;
    }
}