import java.util.*;
import java.io.*; 

public class Main {
	
	static int N; 
	static ArrayList<Integer>[] list; 
	static int[] input, arr; 
	static boolean[] check; 
	
	static void bfs(int start) {
		Queue<Integer> que  = new LinkedList<>(); 
		que.add(start); 
		int cnt =0; 
		check[0] = true; 
		
		while(!que.isEmpty()) {
			int cur = que.remove();
			arr[cnt] = cur; 
			cnt++; 
			for(int x: list[cur]) {
				if(!check[x]) {
					que.add(x); 
					check[x] = true; 
 				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        N = Integer.parseInt(br.readLine()); 
        
        list = (ArrayList<Integer>[])new ArrayList[N];  
        input = new int[N];
        arr = new int[N];
        check = new boolean[N]; 
        
        for(int i=0; i<N; i++) list[i] = new ArrayList<Integer>(); 
        
        
        for(int i=0; i<N-1; i++) {
            String[] str = br.readLine().split(" "); 
            int from = Integer.parseInt(str[0])-1;
            int to = Integer.parseInt(str[1])-1;
            
            list[from].add(to);
            list[to].add(from); 
        }
        String[] str = br.readLine().split(" "); 
        int[] order = new int[N]; 
        for(int i=0; i<N; i++) {
        	input[i] = Integer.parseInt(str[i])-1; 
        	order[input[i]] = i; 
        }
        
        for(int i=0; i<N; i++) {
        	Collections.sort(list[i], new Comparator<Integer>() {
        		public int compare(Integer u, Integer v) {
        			if(order[u] < order[v]) {
        				return -1;
        			} else if(order[u]==order[v]) {
        				return 0; 
        			} else { return 1; }
        		}
        	});
        }
        bfs(input[0]);
        boolean flag = true; 
        for(int i=0; i<N; i++) {
        	if(arr[i]!=input[i]) flag = false; 
        }
        if(flag && input[0]==0) System.out.print(1);
        else System.out.print(0); 
        
        bw.flush();
        bw.close();
    }

}