import java.util.*;
import java.io.*; 


public class Main {

	static int N, M, V;
	static ArrayList<Integer>[] list;
	static boolean[] check;
	
	static void DFS(int x) {
		if(!check[x]) {
			System.out.print(x+" "); 
			check[x] = true; 
		}
		for(int i=0; i<list[x].size(); i++) {
			int t = list[x].get(i);
			if(!check[t]) DFS(t); 
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> Que = new LinkedList<>();
		Que.add(start); 
		check[start] = true; 
		while(Que.size()!=0) {
			int cur = Que.remove();
			System.out.print(cur+" ");
			for(int t: list[cur]) {
				if(!check[t]) {
					Que.add(t); 
					check[t] = true; 
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
        V = Integer.parseInt(st.nextToken()); 
        
        
        list = (ArrayList<Integer>[]) new ArrayList[N+1]; //인접 리스트 
        
        for(int i=0; i<N+1; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	list[from].add(to); 
        	list[to].add(from);
        }
        for(int i=0; i<N+1; i++) {
        	Collections.sort(list[i]);
        }
        check = new boolean[N+1]; 
        DFS(V);
        System.out.println();
        check = new boolean[N+1]; 
        BFS(V);
       
      
       	bw.flush();
        bw.close();
    }
}