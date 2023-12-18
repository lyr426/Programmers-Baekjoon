package 여행경로;

import java.util.*;
class Solution {
    public int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        String[] answer = new String[len+1];
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String o1[], String o2[]){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });

        for(String[] x : tickets){
            System.out.println(x[0] + " _ " + x[1]);
        }

        String cur = "ICN";

        boolean[] visit = new boolean[len];
        String[] route = new String[len+1];
        answer = dfs(tickets, visit, 0, answer, cur);

        return answer;
    }

    public String[] dfs(String[][] tickets, boolean[] visit, int depth, String[] route, String cur){
        route[depth] = cur;
        for(int i=0; i<len; i++) {
            if(!tickets[i][0].equals(cur) || visit[i]){
                continue;
            }
            visit[i] = true;
            String next = tickets[i][1];
            route = dfs(tickets, visit, depth+1, route, next);
            if(route[len] == null){
                visit[i] = false;
            }
        }
        System.out.println(depth);
        return route;
    }
}