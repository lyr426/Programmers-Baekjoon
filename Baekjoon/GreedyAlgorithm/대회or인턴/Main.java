package 대회or인턴;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int team = Math.min(N/2, M);
        N -= team*2;
        M -= team;

        K -= M+N;
        if(K > 0) {
            team -= K/3;
            if( K%3 != 0) team -=1;
        }

        bw.write(String.valueOf(team));
        bw.flush();
        bw.close();

    }

}
