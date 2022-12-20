package 바이러스;

import java.util.*;
import java.io.*; 

public class Main {
	
	static boolean[] check; 
	static int cnt=0; 
	static ArrayList<Integer>[] list;
	
	public static void dfs(int num) {
		if(check[num]==true) {
			return; 
		}
		if(num!=1) { cnt++; }
		check[num] = true; 
		for(int t: list[num]) {
			dfs(t); 
		}
	}
	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        check = new boolean[N+1]; 
        
        list = (ArrayList<Integer>[]) new ArrayList[N+1];
        
        for(int i=0; i<=N; i++) {
        	list[i] = new ArrayList<Integer>(); 
        }
        
        for(int i=0; i<K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	list[from].add(to); 
        	list[to].add(from);
        }
        dfs(1);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}