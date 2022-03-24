import java.util.*;
import java.io.*; 

public class Main {
	
    public static int[] arr;
    public static int[][] d;
    public static StringBuilder str = new StringBuilder(); 
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int N = Integer.parseInt(br.readLine()); 
        arr = new int[N+1];
        d = new int[N+1][2]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }        
        int max = -1; 
        int max_arr = -1; 
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<i; j++) {
        		if(arr[j] < arr[i] && d[j][0]>d[i][0]) {
        			d[i][0] = d[j][0];
        			d[i][1] = j;
        		}
        	}
    		d[i][0]++; 
        	if(max<=d[i][0]) {max=d[i][0]; max_arr = i;}
        }
        
        bw.write(String.valueOf(max)+"\n");
        go(max_arr);
        bw.write(str.toString());

        bw.flush();
        bw.close();
    }
    
    static void go(int num) {
    	if(d[num][1] == 0) {
    		str.append(arr[num]+" ");
    	}
    	else {
    		go(d[num][1]);
    		str.append(arr[num]+" ");
    	}
    }
}