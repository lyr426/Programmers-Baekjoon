package 네트워크;

class Solution {
    private void dfs(int[][] computers, boolean[] visit, int cur){
        if(!visit[cur]) visit[cur] = true;
        for(int i=0; i<computers.length; i++){
            if( i ==cur) continue;
            if(computers[cur][i] == 1 && !visit[i]) dfs(computers, visit, i);
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visit[i]) {
                dfs(computers, visit, i);
                answer++;
            }
        }
        return answer;
    }
}