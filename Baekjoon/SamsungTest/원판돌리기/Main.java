package 원판돌리기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] roulette = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<M; j++){
                roulette[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int j=1; j<=N/x; j++) {
                rotate(roulette, (x*j)-1, d, k);
            }
            check(roulette);
        }
        bw.write(String.valueOf(counting(roulette)));
        bw.flush();
    }

    private static int counting(int[][] roulette) {
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sum += roulette[i][j];
            }
        }
        return sum;
    }

    private static void rotate(int[][] roulette, int x, int d, int k) {

        int[] newRoulette = new int[M];
        if(d == 0) {
            for (int i = 0; i < M; i++) {
                if(i-k < 0 ){
                    newRoulette[i] = roulette[x][M-k+i];
                    continue;
                }
                newRoulette[i] = roulette[x][i-k];
            }
        }else {
            for (int i = 0; i < M; i++) {
                if(i+k >= M ){
                    newRoulette[i] = roulette[x][i-M+k];
                    continue;
                }
                newRoulette[i] = roulette[x][i+k];
            }
        }
        roulette[x] = newRoulette.clone();

    }

    private static void check(int[][] roulette) {
        boolean flag = false;
        int[][] newRoulette = new int[N][M];

        for(int i=0; i<N; i++) {
            newRoulette[i] = roulette[i].clone();
        }

        for(int i=0; i<N; i++) {
            int x = i+1;
            for(int j=0; j<M; j++) {
                int y = j+1>=M ? 0 : j+1;
                if(roulette[i][j] == roulette[i][y] && roulette[i][j] != 0) {
                    newRoulette[i][j] = 0;
                    newRoulette[i][y] = 0;
                    flag = true;
                }
                if(x >= N) continue;
                if(roulette[i][j] == roulette[x][j] && roulette[i][j] != 0) {
                    newRoulette[i][j] = 0;
                    newRoulette[x][j] = 0;
                    flag = true;
                }
            }
        }

        if(!flag){
            int sum = 0;
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    sum += roulette[i][j];
                    if(roulette[i][j]>0) {
                        cnt += 1;
                    }
                }
            }
            if(cnt == 0){
                return;
            }
            int num = sum / cnt;
            int rem = sum % cnt > 0 ? 1 : 0;
            for(int i=0; i<N; i++){
                for (int j = 0; j < M; j++) {
                    if (rem == 0 && num + rem == roulette[i][j]) {
                        newRoulette[i][j] = roulette[i][j];
                        continue;
                    }
                    if(roulette[i][j] == 0) {
                        continue;
                    }
                    newRoulette[i][j] = roulette[i][j] >= num + rem ? roulette[i][j] - 1 : roulette[i][j] + 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            roulette[i] = newRoulette[i].clone();
        }


    }
}
