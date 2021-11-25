import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt =0;
        for(int x[]: commands){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=x[0]-1; i<x[1]; i++) list.add(array[i]);
            Collections.sort(list);
            answer[cnt++] = list.get(x[2]-1);
        }
        return answer;
    }
}