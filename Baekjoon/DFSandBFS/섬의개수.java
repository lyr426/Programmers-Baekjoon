import java.util.*;
import java.io.*; 

public class Main {

	static int h,w; 
    static int[][] arr; 
    static int[][] check; 
    static boolean flag; 
    static ArrayList<Integer>[] list ;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public static void dfs(int x, int y, int cnt) {
    	check[x][y] = cnt; 
    	for(int i=0; i<8; i++) {
    		int xn = x+dx[i];
    		int yn = y+dy[i];
    		if(0<=xn && xn<h && 0<=yn && yn<w) {
    			if(check[xn][yn]==0 &&arr[xn][yn]==1) {
    				dfs(xn, yn, cnt);
    			}
    		}
    	}
    }

	public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        while(true){
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        w = Integer.parseInt(st.nextToken());
	        h = Integer.parseInt(st.nextToken());
	        if(w==0 && h==0) break; 
	        arr= new int[h][w]; 
	        check = new int[h][w]; 
	        int cnt = 0; 
	        for(int i=0; i<h; i++) {
	        	st = new StringTokenizer(br.readLine(), " ");
	        	for(int j=0; j<w; j++) {
	        		arr[i][j] = Integer.parseInt(st.nextToken());
	        	}
	        }
	        for(int i=0; i<h; i++) {
	        	for(int j=0; j<w; j++) {
	        		if(arr[i][j]==1 && check[i][j]==0) {
	        			dfs(i,j,++cnt); 
	        		}
	        	}
	        }
	        bw.write(String.valueOf(cnt));
	        bw.newLine();
        }
       	bw.flush();
        bw.close();
    }
}