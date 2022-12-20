package 유기농배추;

import java.util.*;
import java.io.*; 

public class Main {

	static int N, M; 
    static int[][] arr; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check; 
   
    public static void dfs(int x, int y) {
    	check[x][y] = true; 
    	for(int i=0; i<4; i++) {
    		int xn = x+dx[i];
    		int yn = y+dy[i]; 
    		if(0<=xn&&xn<N&&0<=yn&&yn<M) {
    			if(!check[xn][yn] && arr[xn][yn]==1) dfs(xn, yn); 
    		}
    	}
    }
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	StringTokenizer st= new StringTokenizer(br.readLine(), " "); 
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken()); 
        	
        	check = new boolean[N][M]; 
        	arr = new int[N][M]; 
        	for(int i=0; i<K; i++) {
        		st= new StringTokenizer(br.readLine(), " "); 
        		int y = Integer.parseInt(st.nextToken()); 
        		int x = Integer.parseInt(st.nextToken()); 
        		arr[x][y] = 1; 
        	}
        	int cnt=0; 
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			if(!check[i][j]&&arr[i][j]==1) {
        				dfs(i, j); 
        				cnt++; 
        			}
        		}
        	}
        	bw.write(String.valueOf(cnt)+'\n');
        }
      
       	bw.flush();
        bw.close();
    }
}