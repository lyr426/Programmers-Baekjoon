import java.util.*;
import java.io.*; 

public class Main {
	
	static int maximum = 100000; 
	static int N, K; 
	static int[] dx = {-1, 1}; 
	static int[] visit = new int[maximum+1]; 
    
    public static void bfs() {
    	Queue<Integer> que = new LinkedList<Integer>();
    	
    	que.add(N); 
    	visit[N] = 0; 
    	
    	while(!que.isEmpty()) {
    		int x = que.remove();

    		for(int i=0; i<3; i++) {
    			int xn; 
    			if(i==2) {
    				xn = x*2; 
    			}else {
    				xn = x+dx[i];
    			}
    			if(0<=xn && xn<=maximum) {
    				if(visit[xn]==0) {
    					que.add(xn);
    					visit[xn] = visit[x]+1; 
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
        K = Integer.parseInt(st.nextToken());
        
        bfs(); 
        
        if(N==K) {visit[K] = 0;}
        bw.write(String.valueOf(visit[K]));
      
       	bw.flush();
        bw.close();
    }
}