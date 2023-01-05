package 퇴사;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[N+1];

        for(int i=0; i<N; i++){
            if(i+T[i]<=N){
                d[i+T[i]] = Math.max(d[i+T[i]], d[i]+P[i]);
            }
            d[i+1] = Math.max(d[i+1], d[i]) ;
        }
        bufferedWriter.write(String.valueOf(d[N]));
        bufferedWriter.flush();
    }

}
