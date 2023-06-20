package 평범한배낭;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 갯수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        int[][] object = new int[N+1][2];
        int[][] d = new int[K+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            object[i][0] = Integer.parseInt(st.nextToken()); // 무게
            object[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for(int i=0; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                int w = object[j][0];
                int v = object[j][1];
                d[i][j] = Math.max(d[i][j-1], i-w>=0 ? d[i-w][j-1] +  v : 0);
            }
        }

        bw.write(String.valueOf(d[K][N]));
        bw.flush();
        bw.close();
    }
}
