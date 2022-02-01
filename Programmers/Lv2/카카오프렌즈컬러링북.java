import java.util.*; 
class Solution {
    private int[][] pic;
    private int[][] visit; 
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void dfs(int m, int n, int x,  int y, int cnt){
        visit[x][y] = cnt;
        for(int i=0; i<dx.length; i++){
            int xn = x+dx[i]; 
            int yn = y+dy[i]; 
            if(0<=xn&&xn<m&&0<=yn&&yn<n){
                if(pic[x][y]==pic[xn][yn] && visit[xn][yn]==0){
                    dfs(m, n, xn, yn, cnt); 
                }
            }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new int[m][n]; 
        pic = picture; 

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j] ==0 && picture[i][j]!=0){
                    dfs(m, n, i, j, ++numberOfArea);
                }
            }
        }
        int[] max_area = new int[numberOfArea]; 

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pic[i][j]!=0){
                    max_area[visit[i][j]-1] +=1; 
                }
            }
        }
        Arrays.sort(max_area); 

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = max_area[numberOfArea-1];
        return answer;
    }
}