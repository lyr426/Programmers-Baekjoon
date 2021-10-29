import java.util.*;
class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] d = new int[len][4];
        d[0] =land[0];

        for(int i=1; i<len; i++){
            for(int j=0; j<4; j++){
                int max = -1;
                for(int k=0; k<4; k++){
                    if(j==k) continue;
                    if(max<d[i-1][k]) max=d[i-1][k];
                }
                d[i][j] = land[i][j] + max;
            }
        }

        Arrays.sort(d[len-1]);
        return d[len-1][3];
    }
}