import java.util.*;
import java.io.*; 

class Pair{
	int x;
	int y; 
	Pair(int x, int y){
		this.x = x;
		this.y = y; 
	}
}

public class Main {

	static int N,M; 
    static int[][] arr; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] check; 
   
    
    public static void bfs() {
    	Queue<Pair> que = new LinkedList<Pair>();
    	que.add(new Pair(0,0));
    	check[0][0] = 1;
    	while(!que.isEmpty()) {
    		Pair p = que.remove();
    		int x = p.x;
    		int y = p.y; 
    		for(int i=0; i<4; i++) {
    			int xn = x+dx[i];
    			int yn = y+dy[i]; 
    			if(0<=xn&&xn<N&&0<=yn&&yn<M){
    				if(check[xn][yn]==0 && arr[xn][yn]==1) {
    					que.add(new Pair(xn,yn));
    					check[xn][yn] = check[x][y]+1;
    				}
    			}
    		}
    	}
    }
    

	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        arr= new int[N][M]; 
        check = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	String[] str = br.readLine().split(""); 
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(str[j]); 
        	}
        }
        bfs();

        bw.write(String.valueOf(check[N-1][M-1]));
      
       	bw.flush();
        bw.close();
    }
}