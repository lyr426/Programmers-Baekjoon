import java.util.*;
import java.io.*; 

public class Main {

	
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int max =-1; 
        int[][] arr = new int[N][M]; 
        
        for(int i=0; i<N; i++) {
        	String[] str = br.readLine().split("");
        	for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(str[j]);
        }
        
        for(int s=0; s< (1<<N*M); s++) {
        	int sum=0; 
        	for(int i=0; i<N; i++) {
        		int cur=0;
        		for(int j=0; j<M; j++) {
        			int k = i*M+j; 
        			if((s&(1<<k))==0) cur = cur*10+arr[i][j]; 
        			else {
        				sum+=cur;
        				cur=0; 
        			}
        		}
        		sum+=cur; 
        	}
        	for(int i=0; i<M; i++) {
        		int cur=0; 
        		for(int j=0; j<N; j++) {
        			int k=i+M*j;
        			if((s&(1<<k))!=0)cur =cur*10+arr[j][i];
        			else {
        				sum+=cur;
        				cur=0;
        			}
        		}
        		sum+=cur;
        	}
        	max = Math.max(max, sum);	
        }
        bw.write(String.valueOf(max));
       	bw.flush();
        bw.close();
    }
}