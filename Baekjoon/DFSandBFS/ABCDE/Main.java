package ABCDE;

import java.util.*;
import java.io.*; 

class Edge{
	int from, to;
	Edge(int from, int to){
		this.from = from; 
		this.to = to; 
	}
}

public class Main {

	static int N, M;
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        ArrayList<Edge> edges = new ArrayList<Edge>(); //간선 리스트 
        boolean[][] a = new boolean[N][N];  //인접 행렬 
        ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[N]; //인접 리스트 
        
        for(int i=0; i<N; i++) list[i] = new ArrayList<Integer>();
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	edges.add(new Edge(from, to));
        	edges.add(new Edge(to, from));
        	a[from][to] = a[to][from] = true; 
        	list[from].add(to); 
        	list[to].add(from);
        }
        M*=2; 
        for(int i=0; i<M; i++) {
        	for(int j=0; j<M; j++) {
        		int A = edges.get(i).from;
        		int B = edges.get(i).to;
        		int C = edges.get(j).from;
        		int D = edges.get(j).to;
        		// A->B, C->D 를 찾음 
        		if(A==B || A==C || A==D || B==C || B==D || C==D) continue; 
        		// B->C인지 확인이 필요함
        		if(!a[B][C]) continue;
        		//D->E를 만족하는 관계가 있는지 확인
        		for(int E:list[D]) {
        			if(A==E || B==E || C==E || D==E) continue;
        			System.out.print(1);
        			System.exit(0);
        		}
        	}
        }
        System.out.print(0);
       	bw.flush();
        bw.close();
    }
}