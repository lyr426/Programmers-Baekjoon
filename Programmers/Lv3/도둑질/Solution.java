package 도둑질;

import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[][] d = new int[2][len]; // 0 : 첫번째집 방문한 경우   1 : 방문하지 않은 경우

        d[0][0] = money[0];
        d[0][1] = money[0];
        d[1][0] = 0;
        d[1][1] = money[1];

        for(int i=2; i<len; i++){
            d[0][i] = Math.max(d[0][i-2]+money[i], d[0][i-1]);
            d[1][i] = Math.max(d[1][i-2]+money[i], d[1][i-1]);

        }
        answer = Math.max(d[0][len-2], d[1][len-1]);
        return answer;
    }
}