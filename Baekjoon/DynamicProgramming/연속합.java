import java.util.*;
import java.io.*; 

public class Main {
	
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine()); 
        int arr[] = new int[N+1];
        long d[] = new long[N+1]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken()); 
        long max = -10000l; 
        for(int i=1; i<=N; i++){
        	if(d[i-1]+arr[i]> arr[i]) d[i] = d[i-1]+arr[i];
        	else d[i] = arr[i];
        	if(max < d[i]) max = d[i]; 
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}