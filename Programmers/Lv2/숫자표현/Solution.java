package 숫자표현;

class Solution {
    
    private int dfs(int cur, int n, int sum){
        if(sum>n) return 0;
        if(sum==n) return 1; 
        return dfs(cur+1, n, sum+cur);
    }
    
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) answer += dfs(i,n,0);
        return answer;
    }
}