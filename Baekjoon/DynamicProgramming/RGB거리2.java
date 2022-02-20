import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3]; 
        int[][] d = new int[N+1][3];
        int res = -1; ; 
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        	arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		if(i==j) {
        			d[1][j] = arr[1][j];
        		}
        		else { d[1][j] = 1001;} 
        	}
        	for(int j=2; j<=N; j++) {
        		d[j][0] = Math.min(d[j-1][1], d[j-1][2]) + arr[j][0]; 
        		d[j][1] = Math.min(d[j-1][0], d[j-1][2]) + arr[j][1];
        		d[j][2] = Math.min(d[j-1][0], d[j-1][1]) + arr[j][2]; 
        	}
        	for(int j=0; j<3; j++) {
        		if (i==j) {continue;}
        		else {
        			if (res == -1 ) {res = d[N][j];}
        			res = Math.min(res, d[N][j]);
        		}
        	}
        	
        }
        bw.write(String.valueOf(res)+"\n");
        bw.flush();
        bw.close();
    }

}