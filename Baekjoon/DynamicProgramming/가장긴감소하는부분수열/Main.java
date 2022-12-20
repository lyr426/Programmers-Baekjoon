package 가장긴감소하는부분수열;

import java.util.*;
import java.io.*; 

public class Main {
	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1]; 
        int[] d = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) arr[i] =Integer.parseInt(st.nextToken());
        int res = -1; 
        for(int i=1; i<=N; i++) {
        	d[i] = 1;
        	for(int j=1; j<i; j++) {
	        	if(arr[i]<arr[j]&&d[i]<d[j]+1) d[i] = d[j]+1; 
        	}
        	if(d[i] >= res) res = d[i];
        }
        bw.write(String.valueOf(res)+"\n");
        
        bw.flush();
        bw.close();
    }

}