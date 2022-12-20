package N과M4;

import java.util.*;
import java.io.*; 

public class Main {
	
	public static boolean[] c = new boolean[10];
	public static int[] arr = new int[10]; 
	
	public static StringBuilder go(int index, int start, int n, int m) {
		if(index == m) {
			StringBuilder sb = new StringBuilder(); 
			for(int i=0; i<m; i++) sb.append(arr[i] + " ");
			sb.append("\n"); 
			return sb;
		}
		else {
			StringBuilder sb = new StringBuilder(); 
			for(int i=start; i<=n; i++) { // n =4, m=2 
				//if(c[i]) continue; 
				c[i] = true; 
				arr[index] = i; 
				sb.append(go(index+1, i, n, m)); // 142/ 242
				c[i] = false; 
			}
			return sb; 
		}
	}
	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        bw.write(go(0, 1, N, M).toString());
        
        bw.flush();
        bw.close();
    }

} 