package 사과나무;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt1 = 0;
        int cnt2 = 0;

        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            cnt2 += height/2;
            cnt1 += height%2;
        }

        if( cnt2 - cnt1 >= 0 &&(cnt2 - cnt1)%3 == 0) {
            bw.write("YES");
        } else bw.write("NO");

        bw.flush();
        bw.close();
    }
}
