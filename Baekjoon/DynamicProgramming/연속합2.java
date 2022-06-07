import java.util.*;
import java.io.*; 

public class Main {
	
	//public static long mod = 10007L;
    		
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1]; 
        int[] d = new int[N+1];
        int[] d2 = new int[N+1]; 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int res=0;
        for(int i=1; i<=N; i++) {
        	arr[i] =Integer.parseInt(st.nextToken());
        	res+=arr[i]; 
        }
        for(int i=1; i<=N; i++) {
        	if(d[i-1]+arr[i] > arr[i])d[i] = d[i-1]+arr[i]; 
        	else d[i] = arr[i];
        	if(d[i]>=res) res = d[i];
        }
        d2[N]= arr[N]; 
        for(int i=N-1; i>=1; i--) {
	    	   if(d2[i+1]+arr[i]>arr[i]) d2[i] = d2[i+1]+arr[i]; 
	    	   else d2[i] = arr[i];
	    }
        for(int i=1; i<N; i++) {
        	if(d[i-1]+d2[i+1]>res) res = d[i-1]+d2[i+1];
        }
        bw.write(String.valueOf(res)+"\n");
        
        bw.flush();
        bw.close();
    }

}