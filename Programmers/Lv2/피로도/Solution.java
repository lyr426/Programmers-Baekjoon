package 피로도;
import java.util.*;
class Solution {
    public int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len = dungeons.length;
        for(int i=0; i<len; i++) {
            boolean[] visit = new boolean[len];
            if(dungeons[i][0] <= k) {
                visit[i] = true;
                bruteforce(dungeons, len, k-dungeons[i][1], 1, visit);
            }
        }

        answer = max;
        return answer;
    }

    public void bruteforce(int[][] dungeons, int len, int curHp, int depth, boolean[] visit){
        if(max<depth){
            max = depth;
        }
        if(len == depth || curHp <= 0 ){
            return;
        }
        for(int i=0; i<len; i++) {
            if(!visit[i] && dungeons[i][0] <= curHp){
                visit[i] = true;
                bruteforce(dungeons, len, curHp - dungeons[i][1], depth + 1, visit);
                visit[i] = false;
            }
        }
    }
}