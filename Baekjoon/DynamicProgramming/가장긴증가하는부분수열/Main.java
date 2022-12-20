package 가장긴증가하는부분수열;

import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
     
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }        
        int max = -1; 
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<i; j++) {
        		if(arr[j] < arr[i] && d[j]>d[i]) {
        			d[i] = d[j];
        		}
        	}
    		d[i]++; 
        	if(max<=d[i]) {max=d[i];}
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}