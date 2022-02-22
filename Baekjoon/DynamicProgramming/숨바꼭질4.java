import java.util.*;
import java.io.*; 


public class Main {
	
	static int maximum = 100000; 
	static int N, K; 
	static int[] dx = {-1, 1}; 
	static int[] visit = new int[maximum+1]; 
	static int[] front = new int[maximum+1]; 
    
    public static void bfs() {
    	Queue<Integer> que = new LinkedList<Integer>();
    	que.add(N); 
    	visit[N] = 0; 
    	while(!que.isEmpty()) {
    		int x = que.remove();

    		for(int i=0; i<3; i++) {
    			int xn; 
    			if(i==2) xn = x*2; 
    			else xn = x+dx[i];
    			if(0<=xn && xn<=maximum) {
    				if(visit[xn]==0) {
    					que.add(xn);
    					visit[xn] = visit[x]+1; 
    					front[xn] = x; 
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
        
        if(N==K) visit[K] = 0; front[K] =-1;
        
        int num = visit[K];
        front[N] = N; 
        int[] arr = new int[num+2]; 
        int f = K; 
        
        for(int i=0; i<num; i++) {
        	arr[num-i] = front[f]; 
        	f = arr[num-i]; 
        }
        arr[num+1] = K;
        System.out.println(num); 
        for(int i=1; i<=num+1; i++) System.out.print(arr[i]+" ");
       	bw.flush();
        bw.close();
    }
}