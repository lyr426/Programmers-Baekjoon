package 연구소;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N = 3;
    static int M = 3;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(map, 0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
    }
    static void comb(int[][] map, int start, int depth) {
        if (depth == 3) {
            max = Math.max(max,bfs(map));
//            System.out.println(bfs(map));
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                comb(map, i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    static int bfs(int[][] map) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Pair> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    que.add(new Pair(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while (!que.isEmpty()){
            Pair pair = que.remove();
            int x = pair.x;
            int y = pair.y;

            for(int i=0; i<4; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];
                if(xn < 0 || xn >= N || yn < 0 || yn >= M){
                    continue;
                }
                if(!visit[xn][yn] && map[xn][yn] == 0) {
                    que.add(new Pair(xn, yn));
                    visit[xn][yn] = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(!visit[i][j] && map[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

}
