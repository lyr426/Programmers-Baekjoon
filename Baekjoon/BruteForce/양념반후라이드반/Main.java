package 양념반후라이드반;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int min = Math.min(X, Y);
        int max = Math.max(X, Y);

        int result = A+B < C*2 ? A * X + B * Y : (min == X ? C * X * 2 + B * (Y-X) : C * Y * 2 + A * (X-Y) );
        result = result < C * 2 * max ? result : C * 2 * max;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
