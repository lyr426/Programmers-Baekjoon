package 문제집;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] priority = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            priority[i][0] = Integer.parseInt(st.nextToken());
            priority[i][1] = Integer.parseInt(st.nextToken());
        }

    }
}
