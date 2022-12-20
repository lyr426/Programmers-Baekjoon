package 내려가기;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] max = new int[2][N];
        int[][] min = new int[2][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                if(st.hasMoreTokens()) arr[j]= Integer.parseInt(st.nextToken());
                int max_num = max[0][j], min_num = min[0][j];
                if(j-1>=0) {
                    max_num = Math.max(max_num, max[0][j-1]);
                    min_num = Math.min(min_num, min[0][j-1]);
                }
                if(j+1<N) {
                    max_num = Math.max(max_num, max[0][j+1]);
                    min_num = Math.min(min_num, min[0][j+1]);
                }
                max[1][j] = max_num + arr[j];
                min[1][j] = min_num + arr[j];
            }
            max[0] = max[1].clone();
            min[0] = min[1].clone();
        }
        Arrays.sort(max[1]);
        Arrays.sort(min[1]);
        bw.write(String.valueOf(max[1][N-1])+" "+String.valueOf(min[1][0]));
        bw.flush();
    }
}
