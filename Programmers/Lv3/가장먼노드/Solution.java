package 가장먼노드;

import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] list = new ArrayList[n]; 
        Queue<Integer> que = new LinkedList<>(); 
        int[] distance = new int[n]; 
        for(int i=0; i<n; i++) list[i] = new ArrayList<Integer>();
        for(int[] k: edge) {
            list[k[0]-1].add(k[1]-1);
            list[k[1]-1].add(k[0]-1);
        }
        que.add(0);
        int max = -1;
        while (!que.isEmpty()){
            int node = que.poll();
            for(int x: list[node]){
                if(x!=0 &&distance[x] == 0){
                    que.add(x);
                    distance[x] = distance[node]+1;
                }
            }
            max = distance[node];
        }
        for(int x: distance){
            if(x==max) answer++;
        } 
        return answer;
    }
}