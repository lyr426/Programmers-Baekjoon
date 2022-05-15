import java.util.*;
import java.io.*; 

public class Main {
	
	public static long mod = 10007L;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][11];
        for(int i=1; i<=N; i++) {
        	for(int j=0; j<10; j++) {
        		d[i][j] = 0;
        		if (i==1) d[i][j] = 1;
        		else {
	        		for(int k=j; k<10; k++) {
	            		d[i][j] += d[i-1][k];
	            		d[i][j] %= mod; 
	        		}
        		}
        		d[i][10] += d[i][j]; 
        	}
        	d[i][10]%= mod; 
        }
        bw.write(String.valueOf(d[N][10]%mod));
        bw.flush();
        bw.close();
    }

}