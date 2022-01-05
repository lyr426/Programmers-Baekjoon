import java.util.*;
import java.io.*; 

public class Main {
	
	public static int go(int sum, int goal) {
		if(sum == goal ) {return 1;}
		if(sum>goal) {return 0;}
		int res =0; 
		for(int i=1; i<=3; i++) {
			res += go(sum+i, goal);
		}
		return res; 
	}
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine()); 
        	bw.write(String.valueOf(go(0,N)+"\n"));
        }
        
        
        bw.flush();
        bw.close();
    }
}