import java.util.*;
import java.io.*; 

public class Main {	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][N+1]; 
        int[][] d = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	for(int j=1; j<=i; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()); 
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=i; j++) {
        		if(i==1) {
        			d[i][j] = arr[i][j];
        		}
        		else {
        			d[i][j] = Math.max(d[i-1][j-1], d[i-1][j])+arr[i][j];
        		}
        		
        	}
        }
        int res = -1; 
        for(int i=1; i<=N; i++) {
        	if(d[N][i]>=res) {
        		res = d[N][i];
        	}
        }
       
        bw.write(String.valueOf(res)+"\n");
        
        bw.flush();
        bw.close();
    }

}