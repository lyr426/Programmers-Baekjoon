package 로봇청소기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int cnt;
    static int[][] visit;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N][M];
        arr = new int[N][M];
        cnt = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                visit[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void clean(int r, int c, int d) {
        System.out.println("r = " + r);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println(" ================ " );
        if(visit[r][c] == 0) {
            visit[r][c] = 1;
            cnt += 1;
            arr[r][c] = cnt;
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
                System.out.println("i = " + i);
            }
            clean(r+dx[d], c+dy[d],d);
        }else{
            int dr = r - dx[d];
            int dc = c - dy[d];
            if(dr>=0 && dr<N && dc>=0 && dc<M){
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
