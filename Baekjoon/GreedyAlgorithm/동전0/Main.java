package 동전0;

import java.util.*;
import java.io.*; 
public class Main {

	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int cnt =0; 
		String[] str = br.readLine().split(" "); 
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] arr = new int[N]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		while(K!=0) {
			if( K >= arr[N-1] ) {
				cnt+= K / arr[N-1];
				K %= arr[N-1];
			}
			N--;
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
    }
}