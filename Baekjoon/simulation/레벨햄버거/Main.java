package 레벨햄버거;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[][] d = new long[N+1][3];
        d[0][1] = 1;
        for (int i=1; i<=N; i++) {
            d[i][0] = d[i-1][0]*2 + 2;  //번 갯수
            d[i][1] = d[i-1][1]*2 + 1;  //패티 갯수
            d[i][2] = (d[i][0] + d[i][1]) / 2 + 1; // 중간 길이
        }

        long result = 0L;
        int curN = N;
        while (X > 0 && curN >= 0) {
            if(X >= d[curN][2]) {
                result += d[curN][1]/2 + 1;
                X -= d[curN][2]; // => 3
            }else {
                X -= 1;
            }
            curN -= 1;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

}
