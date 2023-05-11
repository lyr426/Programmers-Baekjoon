package 등굣길;

class Solution {
    final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[n][m];
        d[0][0] = 1;
        for(int[] x: puddles){
            d[x[1]-1][x[0]-1] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) continue;
                if(d[i][j] == -1) continue;
                if(i-1 >= 0 && d[i-1][j] != -1) d[i][j] += d[i-1][j];
                if(j-1 >= 0 && d[i][j-1] != -1) d[i][j] += d[i][j-1];
                d[i][j] %= MOD;
            }
        }
        return d[n-1][m-1]%MOD;
    }
}