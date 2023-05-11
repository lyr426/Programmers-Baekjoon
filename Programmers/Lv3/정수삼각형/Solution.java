package 정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer =0;
        int n = triangle.length;

        int[][] d = new int[n][n];
        d[0][0] = triangle[0][0];

        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j==0) d[i][j] = d[i-1][0]+triangle[i][0];
                else if (i==j) d[i][j] = d[i-1][j-1] + triangle[i][j];
                else d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + triangle[i][j];
            }
        }
        for(int i=0; i<n; i++) if(d[n-1][i]>answer) answer = d[n-1][i];
        return answer;
    }
}