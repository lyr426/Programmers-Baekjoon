package a01타일;

import java.util.*;
import java.io.*; 

public class Main {
    
    public static long MOD = 15746; 
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        for(int i=1; i<=N; i++){
            if (i<=2){
                d[i] = i;
                continue; 
            }
            d[i] = d[i-2]+d[i-1]; 
            d[i]%=MOD;
        }
        bw.write(String.valueOf(d[N]%MOD)); 
        bw.flush();
        bw.close();
    }
}