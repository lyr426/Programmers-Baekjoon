package Math.약수의합2;

import java.io.*;

public class Main {

    static public int N;
    static public int L;

    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;

        for(int i=1; i<=N; i++) {
            result += N / i * i;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}