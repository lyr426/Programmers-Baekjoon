package 게임맵최단거리;
import java.util.*;
class Pair{
    final private int x; 
    final private int y;
    public int getX(){
        return x; 
    }
    public int getY(){
        return y; 
    }
    Pair(int x, int y){
        this.x = x;
        this.y = y; 
    }
}

class Solution {
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; 
        int m = maps[0].length; 
        int[][] visit = new int[n][m];
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1}; 
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0)); 
        visit[0][0] = 1; 
        
        while(!que.isEmpty()){
            Pair p = que.remove(); 
            int x = p.getX(); int y = p.getY();
            for(int i=0; i<dx.length; i++){
                int xn = x+dx[i];
                int yn = y+dy[i];
                if(0<=xn&&xn<n&&0<=yn&&yn<m){
                    if(visit[xn][yn]==0&&maps[xn][yn]==1){
                        visit[xn][yn] = visit[x][y]+1;
                        que.add(new Pair(xn, yn)); 
                    }
                }
            }
        }
        if(visit[n-1][m-1]==0){return -1;}
        return visit[n-1][m-1]; 
    }
}