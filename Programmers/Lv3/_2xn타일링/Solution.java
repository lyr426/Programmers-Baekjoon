package _2xn타일링;

class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        int[] d = new int[n+1];
        
        d[1] = 1; 
        d[2] = 2; 
        for(int i=3; i<=n; i++){
            d[i] = d[i-2] + d[i-1]; 
            d[i] %= MOD; 
        }
        
        return d[n];
    }
}