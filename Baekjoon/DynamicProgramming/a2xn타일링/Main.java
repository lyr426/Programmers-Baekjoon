package a2xn타일링;

import java.util.*;
import java.io.*; 

public class Main {

    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N+1]; 
        cnt[0] = 1; 
        cnt[1] = 1;
        
        for(int i=2; i<=N; i++){
            cnt[i] = cnt[i-1] + cnt[i-2];
            cnt[i] %= 10007;
        }
        bw.write(String.valueOf(cnt[N])); 
        bw.flush();
        bw.close();
    }
    
}