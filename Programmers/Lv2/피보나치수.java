class Solution {
    public final int MOD = 1234567;
    public int solution(int n) {
        int[] d = new int[n+1];
        d[1] = 1; 
        for(int i=2; i<=n; i++){
            d[i] = d[i-1]+d[i-2]; 
            d[i] %= MOD; 
        }
        
        return d[n];
    }
}