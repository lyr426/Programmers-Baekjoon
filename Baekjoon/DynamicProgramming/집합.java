
import java.util.*;
import java.io.*; 

public class Main {
	
	static int N, len; 
	static int[] A;
	static char[][] S;
	
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); 
        ArrayList<Integer> S = new ArrayList<>(); 
        
        int res=0;
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	String com = st.nextToken(); 
        	int x; 
        	
        	switch(com){
        		case "add":
        			x = Integer.parseInt(st.nextToken()); 
        			res = res|(1<<x); 
        			break;
        		case "remove":
        			x = Integer.parseInt(st.nextToken()); 
        			res = res& ~(1<<x); 
        			break;
        		case "check":
        			x = Integer.parseInt(st.nextToken()); 
        			int t = res&(1<<x); 
        			if(t==0) {bw.write("0"+"\n");}
        			else {bw.write("1"+"\n");}
        			break;
        		case "toggle":
        			x = Integer.parseInt(st.nextToken()); 
        			res = res^(1<<x); 
        			break;
        		case "all":
        			res =0; 
        			int j=21;
        			while(j-- > 0) {
        				res+= (1<<j); 
        			}
        			break;
        		case "empty":
        			res=0;
        			break;
        			
        	}
        }
        
       	bw.flush();
        bw.close();
    }
}