package 테트로미노;

import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
       
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int max = -1;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		int sum=0; 
        		if(j+3<M){//가로 일자 
        			sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
        			max = Math.max(max, sum);
        		}
        		if(i+3<N) {//세로 일자 
        			sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
        			max = Math.max(max, sum);
        		}
        		if(i+2<N && j+2<M) { //네모 
        			sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
        			max = Math.max(max, sum);
        		}
        		if(i+2<N && j+1<M) { // L
        			sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
        			max = Math.max(max, sum);
        			sum = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
        			max = Math.max(max, sum);
        		}
        		if(i+1<N && j+2<M) {
        			sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
        			max = Math.max(max, sum);
        			sum = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+2];
        			max = Math.max(max, sum);
        		}
        		if(i+2<N && j+1<M) {
        			sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
        			max = Math.max(max, sum);
        			sum = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
        			max = Math.max(max, sum);
        		}
        		if(i+1<N && j+2<M) {
        			sum = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
        			max = Math.max(max, sum);
        		}
        		if(i+1<N && j+2<M) {
        			sum = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
        			max = Math.max(max, sum);
        		}
        		if(i+2<N && j+1<M) {
        			sum = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
        			max = Math.max(max, sum);
        			sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
        			max = Math.max(max, sum);
        		}
        	}
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}