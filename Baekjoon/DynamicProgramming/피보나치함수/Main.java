package 피보나치함수;

import java.util.*;
import java.io.*; 

public class Main {
    
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] d= new int[41][2]; 
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=40; i++){
            if(i==0){d[i][0] = 1;}
            else if(i==1){d[i][1] = 1;}
            else {
                d[i][0] = d[i-1][0] + d[i-2][0];
                d[i][1] = d[i-1][1] + d[i-2][1]; 
            }
        }
        
        for(int i=0; i<N; i++){
            int k = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(d[k][0] +" "+d[k][1]+"\n"));
        }
        
        bw.flush();
        bw.close();
    }
}