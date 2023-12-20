package 순위;

import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] winResults = new ArrayList[n+1];
        List<Integer>[] loseResults = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            winResults[i] = new ArrayList<>();
            loseResults[i] = new ArrayList<>();
        }

        for(int[] result : results) {
            int win = result[0];
            int lose = result[1];
            winResults[win].add(lose);
            loseResults[lose].add(win);
        }
        boolean[] winVisit = new boolean[n+1];
        boolean[] loseVisit = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(!winVisit[i]){
                dfs(i, n, winVisit, winResults);
            }
            if(!loseVisit[i]){
                dfs(i, n, loseVisit, loseResults);
            }
        }

        for(int i=1; i<=n; i++) {
            int sum = winResults[i].size() + loseResults[i].size();
            if(sum == n-1) {
                answer += 1;
            }
        }

        return answer;
    }
    public void dfs(int cur, int n, boolean[] visit, List<Integer>[] resultList) {
        visit[cur] = true;
        List<Integer> addList = new ArrayList<>();
        for(int x : resultList[cur]){
            if(!visit[x]) {
                dfs(x, n, visit, resultList);
            }
            for(int y: resultList[x]){
                if(!resultList[cur].contains(y) && !addList.contains(y)){
                    addList.add(y);
                }
            }
        }
        resultList[cur].addAll(addList);
    }
}