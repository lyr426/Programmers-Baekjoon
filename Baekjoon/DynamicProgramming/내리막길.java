import java.util.*;
import java.io.*; 

public class Main {
	
	static int[][] arr; 
	static int N, M; 
	static long cnt =0; 
	static int m[][]; 
    static boolean[][] check;
    
	public static int go(int h, int w) {
		if(h==0 && w ==0) return 1; 
		if(h>0) {
			if(arr[h][w] < arr[h-1][w]) {
				if(check[h-1][w]) {
					m[h][w] += m[h-1][w]; 
				}
				else {
					m[h][w] += go(h-1, w); 
				}
			}
		}
		if(h<M-1) {
			if(arr[h][w] < arr[h+1][w]) {
				if(check[h+1][w]) {
					m[h][w] += m[h+1][w]; 
				}
				else {
					m[h][w] += go(h+1, w); 
				}
			}
		}
		if(w>0) {
			if(arr[h][w] < arr[h][w-1]) {
				if(check[h][w-1]) {
					m[h][w] += m[h][w-1]; 
				}
				else {
					m[h][w] += go(h, w-1); 
				}
			}
		}
		if(w<N-1) {
			if(arr[h][w] < arr[h][w+1]) {
				if(check[h][w+1]) {
					m[h][w] += m[h][w+1]; 
				}
				else {
					m[h][w] += go(h, w+1); 
				}
			}
		}
		check[h][w] = true; 
		return m[h][w]; 
	}
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N]; 
        m = new int[M][N];
        check = new boolean[M][N]; 
        
        for(int i=0; i<M; i++) {
        	 st = new StringTokenizer(br.readLine(), " "); 
        	for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(go(M-1,N-1)));
        
        bw.flush();
        bw.close();
    }

}