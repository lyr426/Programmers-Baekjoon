package 나이트의이동;

import java.util.*;
import java.io.*; 

class Pair{
	public int x;
	public int y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y; 
	}
}

public class Main {

	static int N, cur_x, cur_y, goal_x, goal_y; 
    static int[][] arr; 
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[][] check; 
   
    
    public static void bfs() {
    	Queue<Pair> que = new LinkedList<Pair>();
    	
        que.add(new Pair(cur_x,cur_y)); 
        check[cur_x][cur_y] = 0;
        
    	while(!que.isEmpty()) {
    		Pair p = que.remove();
    		int x = p.x;
    		int y = p.y; 
    		if(x==goal_x&&y==goal_y) {
				System.out.println(check[x][y]);
				break;
			}
    		for(int i=0; i<8; i++) {
    			int xn = x+dx[i];
    			int yn = y+dy[i]; 
    			if(0<=xn&&xn<N&&0<=yn&&yn<N){
    				if(check[xn][yn]==0) {
    					check[xn][yn] = check[x][y]+1; 
    					que.add(new Pair(xn, yn));
    				}
    			}
    		}
    	}
    }
    

	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	N = Integer.parseInt(br.readLine());
        	check = new int[N][N]; 
        	arr = new int[N][N]; 
        	String[] str = br.readLine().split(" ");
        	cur_x = Integer.parseInt(str[0]); 
        	cur_y = Integer.parseInt(str[1]);
        	str = br.readLine().split(" "); 
        	goal_x = Integer.parseInt(str[0]); 
        	goal_y = Integer.parseInt(str[1]);
        	bfs();
        }
      
       	bw.flush();
        bw.close();
    }
}