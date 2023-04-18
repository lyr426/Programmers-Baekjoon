package 타일채우기;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] tile = new int[N+1];
        tile[0] = 1;
        if(N%2 == 0) {
            for (int i = 2; i <= N; i+=2) {
                tile[i] = tile[i - 2] * 3;
                for (int j = i; j > 2; j -= 2){
                    tile[i] += tile[i - j] * 2;
                }
            }
        }

        bw.write(String.valueOf(tile[N]));
        bw.flush();
        bw.close();
    }
}
