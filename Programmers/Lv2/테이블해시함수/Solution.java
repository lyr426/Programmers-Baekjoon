package 테이블해시함수;

import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int len = data.length;
        // col -= 1;
        row_begin -= 1;
        row_end -= 1;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] == o2[col-1]) {
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        });

        for(int i=row_begin; i<=row_end; i++) {
            int sum = 0;
            for(int j=0; j<data[0].length; j++) {
                sum += data[i][j]%(i+1);
            }
            if(i == row_begin) {
                answer = sum;
                continue;
            }
            answer = answer ^ sum;
        }

        return answer;
    }

}