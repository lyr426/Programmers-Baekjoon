package GCD합;

import java.util.*;
import java.io.*;

public class Main {
	
	public static int GCD(int a, int b) {
		if(a==0) return b;
		else return GCD(b%a, a);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cnt= Integer.parseInt(st.nextToken());
			long sum=0l;
			int[] arr = new int[cnt];
			for(int i=0; i<cnt; i++) arr[i] = Integer.parseInt(st.nextToken()); 
			for(int j=0; j<cnt-1; j++) {
				for(int k=j+1;k<cnt; k++) sum+= GCD(arr[j], arr[k]); 
			}
			bw.write(String.valueOf(sum)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
