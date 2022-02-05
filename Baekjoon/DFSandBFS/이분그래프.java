import java.util.*;
import java.io.*; 

public class Main {

	static int N; 
    static int[][] arr; 
    static int[] check; 
    static boolean flag; 
    static ArrayList<Integer>[] list ;
    
    public static void dfs(int x, int bi) {
    	check[x] = bi;
    	for(int k: list[x]) {
    		if(check[k] == 0 ) {
    			dfs(k, bi%2+1);
    		}
    		else if(check[k]==bi) {
    			flag=false; 
    		}
    	}
    }
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        
        for(int test=0; test<K; test++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        int V = Integer.parseInt(st.nextToken());
	        int E = Integer.parseInt(st.nextToken());
	        check = new int[V+1]; 
	        
	        list = (ArrayList<Integer>[]) new ArrayList[V+1]; 
	        
	        for(int i=0; i<V+1; i++) {
	        	list[i] = new ArrayList<Integer>(); 
	        }
	        
	        for(int i=0; i<E; i++) {
	        	st = new StringTokenizer(br.readLine(), " ");
	        	int from = Integer.parseInt(st.nextToken());
	        	int to = Integer.parseInt(st.nextToken());
	        	
	        	list[from].add(to);
	        	list[to].add(from);
	        }
	        flag = true; 
	        for(int i=1; i<V+1; i++) {
	        	if(check[i]==0) {
	        		dfs(i, 1);
	        	}
	        }
	        if(!flag) {
	        	bw.write("NO"+"\n");
	        }
	        else {
	        	bw.write("YES"+"\n");
	        }
        }
       
       	bw.flush();
        bw.close();
    }
}