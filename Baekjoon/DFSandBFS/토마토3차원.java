import java.util.*;
import java.io.*; 

class Pair{
	int x;
	int y; 
	int h;
	Pair(int h, int x, int y){
		this.h = h; 
		this.x = x;
		this.y = y; 
	}
}

public class Main {

	static int N,M,H; 
    static int[][][] arr; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dh = {-1, 1}; 
    static int[][][] check; 

    public static void bfs() {
    	Queue<Pair> que = new LinkedList<Pair>();
    	for(int h=0; h<H; h++) {
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<M; j++) {
	        		if(arr[h][i][j]==1) {
	        			que.add(new Pair(h,i,j));
	        	    	check[h][i][j] = 0;
	        		}
	        	}
	        }
    	}
    	while(!que.isEmpty()) {
    		Pair p = que.remove();
    		int h = p.h; 
    		int x = p.x;
    		int y = p.y; 
    		for(int i=0; i<4; i++) {
    			int xn = x+dx[i];
    			int yn = y+dy[i]; 
    			if(0<=xn&&xn<N&&0<=yn&&yn<M){
    				if(arr[h][xn][yn]!=-1 && (check[h][xn][yn]==-1||check[h][xn][yn]>check[h][x][y]+1)) {
    					que.add(new Pair(h, xn,yn));
    					check[h][xn][yn] = check[h][x][y]+1;
    				}
    			}
    		}
    		for(int i=0; i<2; i++) {
    			int hn = h+dh[i];
    			if(0<=hn&&hn<H){
    				if(arr[hn][x][y]!=-1 && (check[hn][x][y]==-1||check[hn][x][y]>check[h][x][y]+1)) {
    					que.add(new Pair(hn, x,y));
    					check[hn][x][y] = check[h][x][y]+1;
    				}
    			}
    		}
    		
    	}
    }
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken());
        arr= new int[H][N][M]; 
        check = new int[H][N][M];
        
        for(int h=0; h<H; h++) {
	        for(int i=0; i<N; i++) {
	        	String[] str = br.readLine().split(" "); 
	        	for(int j=0; j<M; j++) {
	        		arr[h][i][j] = Integer.parseInt(str[j]); 
	        		check[h][i][j] =-1;
	        	}
	        }
		}
        bfs();
        int max=-1;
        for(int h=0; h<H; h++) {
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<M; j++) {
	        		if(check[h][i][j]==-1 && arr[h][i][j]==0 ) {
	        			System.out.print(-1);
	        			System.exit(0);
	        		}
	        		max = Math.max(max,check[h][i][j]);
	        	}
	        }
        }
        bw.write(String.valueOf(max));
       	bw.flush();
        bw.close();
    }
}