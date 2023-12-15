package 섬연결하기;

import java.util.*;

class Pair{
    int node;
    int value;

    Pair(int node, int value){
        this.node = node;
        this.value = value;
    }
}
class Solution {
    public int solution(int n, int[][] costs) {
        int len = costs.length;
        int answer = 0;

        ArrayList<Pair>[] lists = new ArrayList[n];
        for(int i=0; i<n; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i=0; i<costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int value = costs[i][2];

            lists[from].add(new Pair(to, value));
            lists[to].add(new Pair(from, value));
        }
        PriorityQueue<Pair> que = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.value - o2.value;
            }
        });
        boolean[] visit = new boolean[n];
        for(Pair x : lists[0]){
            que.add(x);
        }
        visit[0] = true;
        while (!que.isEmpty()){
            Pair cur = que.poll();
            if(visit[cur.node]){
                continue;
            }
            visit[cur.node] = true;
            answer += cur.value;
            for(Pair x : lists[cur.node]){
                if(!visit[x.node]){
                    que.add(x);
                }
            }
        }


        return answer;
    }
}