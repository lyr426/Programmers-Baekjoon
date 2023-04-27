package 점프점프;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] maze = new int[N];
        int[] d = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = 1;
        for(int i=0; i<N; i++) {
            if(d[i] == 0) continue;
            for(int j=1; j<=maze[i]; j++) {
                if(i+j >= N) break;
                if(d[i+j] == 0) {
                    d[i+j] = d[i]+1;
                } else{
                    d[i+j] = Math.min(d[i]+1, d[i+j]);
                }
            }
        }
        if(d[N-1] == 0){
            bw.write("-1");
        }else {
            bw.write(String.valueOf(d[N-1]-1));
        }
        bw.flush();
        bw.close();

    }
}
