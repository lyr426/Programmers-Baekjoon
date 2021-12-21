class Solution {
    final long MOD = 1234567;    
    public long solution(int n) {
        long [] d = new long[n+1];
        d[0] = 1; 
        d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1]+d[i-2];
            d[i] %= MOD;
        }
        return d[n];
    }
}