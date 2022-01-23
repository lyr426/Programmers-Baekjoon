import java.util.*;
import java.io.*; 

public class Main {

	static int N; 
    static int[][] arr; 
    static int[][] check; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void dfs(int x, int y, int cnt) {
    	check[x][y] = cnt;
    	for(int i=0; i<4; i++) {
    		int xn = x+dx[i]; 
    		int yn = y+dy[i];
    		
    		if(0<=xn && xn<N && 0<=yn && yn<N) {
	    		if(check[xn][yn] ==0 && arr[xn][yn] == 1) {
	    			dfs(xn, yn, cnt); 
	    		}
    		}
    	}
    }
	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); 
        
        arr = new int[N][N]; 
        check = new int[N][N]; 
        
        for(int i=0; i<N; i++) {
        	String[] str = br.readLine().split("");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(str[j]); 
        	}
        }
        int cnt=0; 
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j]==1 && check[i][j]==0)  dfs(i,j,++cnt); 
        	}
        }
        int[] res = new int[cnt];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j]==1) res[check[i][j]-1] +=1; 
        	}
        }
        Arrays.sort(res);
        bw.write(String.valueOf(cnt)+"\n");
        for(int i=0; i<cnt; i++) bw.write(String.valueOf(res[i])+"\n");
        bw.flush();
        bw.close();
    }
}