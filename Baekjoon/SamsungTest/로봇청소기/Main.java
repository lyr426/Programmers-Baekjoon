package 로봇청소기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int cnt;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N][M];
        cnt = 1;

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                visit[i][j] = Integer.parseInt(st.nextToken());
                if(visit[i][j] == 1) visit[i][j] = -1;
            }
        }
        clean(r, c, d);

        bw.write(String.valueOf(cnt-1));
        bw.flush();
        bw.close();
    }

    private static void clean(int r, int c, int d) {

        if(visit[r][c] == 0) {
            visit[r][c] = cnt;
            cnt += 1;
        }
        boolean flag = check(r, c);

        if(!flag){ //청소되지 않은 빈칸이 있는 경우
            for(int i=0; i<4; i++){
                d = (d+3)%4;
                int dr = r + dx[d];
                int dc = c + dy[d];
                if(dr>=0 && dr<N && dc>=0 && dc<M){
                    if(visit[dr][dc] == 0) break;
                }
            }
            clean(r+dx[d], c+dy[d],d);
        }else{
            int dr = r - dx[d];
            int dc = c - dy[d];
            if(dr>=0 && dr<N && dc>=0 && dc<M && visit[dr][dc] != -1){
                clean(dr, dc, d);
            }
        }
    }

    private static boolean check(int r, int c) {

        for(int i=0; i<4; i++){
            int dr = r + dx[i];
            int dc = c + dy[i];
            if(dr>=0 && dr<N && dc>=0 && dc<M){
                if(visit[dr][dc] == 0) return false;
            }
        }
       return true;
    }
}
