import java.util.*;
class Solution {
    private int gcd(int a, int b){
        if(b==0) return a; 
        return gcd(b, a%b); 
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n,m), Math.min(n,m)); 
        answer[1] = n*m/answer[0];
        return answer;
    }
}