package 이동하기;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] d = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        d[0][0] = arr[0][0];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(i==0 && j==0) continue;
                int max = 0;
                if(i!=0 && j!=0) max = Math.max(max, d[i-1][j-1]);
                if(i!=0) max = Math.max(max, d[i-1][j]);
                if(j!=0) max = Math.max(max, d[i][j-1]);
                d[i][j] = max+arr[i][j];
            }
        }
        bw.write(String.valueOf(d[N-1][M-1]));
        bw.flush();
    }
}
