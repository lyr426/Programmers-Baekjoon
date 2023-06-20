package BOJ거리;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        int[] block = new int[N+1];
        char[] tmp = br.readLine().toCharArray();
        for(int i=1; i<=N; i++) {
            if(tmp[i-1] == 'B') block[i] = 0;
            else if(tmp[i-1] == 'O') block[i] = 1;
            else block[i] = 2;
        }

        for(int i=1; i<=N; i++){
            if(i != 1 && d[i] == 0) continue;
            int next = (block[i] + 1) % 3;
            for(int j=i+1; j<=N; j++) {
                if(block[j] == next) {
                    int cur = d[i] + (j-i)*(j-i);
                    d[j] = d[j] == 0 ?  cur : Math.min(d[j], cur);
                }
            }
        }

        if(d[N] == 0) bw.write("-1");
        else bw.write(String.valueOf(d[N]));

        bw.flush();
        bw.close();
    }
}
