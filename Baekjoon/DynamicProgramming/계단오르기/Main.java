package 계단오르기;

import java.util.*;
import java.io.*; 

public class Main {
    
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N+1];
        long[] d = new long[N+1];
        
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        } 
        for(int i=1; i<=N; i++){
            if(i<=2){
                d[i] = arr[i-1]+arr[i];
            }
            else {
            	d[i] = Math.max(d[i-2]+arr[i], d[i-3]+arr[i-1]+arr[i]);
            }
        }
        
        bw.write(String.valueOf(d[N]));
        bw.flush();
        bw.close();
    }
}