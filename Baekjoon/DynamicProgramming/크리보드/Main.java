package 크리보드;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][2];
        d[1][0] = 1;
        d[1][1] = 1;

        for(int i=2; i<=N; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][1];

            if(i>= 4 && d[i-4][0] * 3 >= d[i][0]) {
                d[i][0] = d[i-4][0] * 3;
                d[i][1] = d[i-4][0];
            }
        }

        bw.write(String.valueOf(d[N][0]));
        bw.flush();
        bw.close();
    }

}
