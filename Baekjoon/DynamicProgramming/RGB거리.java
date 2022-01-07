import java.util.*;
import java.io.*; 

public class Main {
	
	//public static long mod = 10007L;
    		
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N+1][3]; 
        int[][] arr = new int[N+1][3];
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine()," ");
        	for(int j=0; j<3; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	if(i==1) {
        		d[i][0] = arr[i][0]; 
        		d[i][1] = arr[i][1];
        		d[i][2] = arr[i][2];	
        	}
        	else {
        		d[i][0] = Math.min(d[i-1][1], d[i-1][2])+arr[i][0];
        		d[i][1] = Math.min(d[i-1][0], d[i-1][2])+arr[i][1];
        		d[i][2] = Math.min(d[i-1][0], d[i-1][1])+arr[i][2];
        	}
        }
        
        int res = Math.min(d[N][0], d[N][1]);
        res = Math.min(res, d[N][2]);
           
        bw.write(String.valueOf(res));
        		
        
        
        bw.flush();
        bw.close();
    }

}