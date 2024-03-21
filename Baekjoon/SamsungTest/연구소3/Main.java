package 연구소3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(lab, 0, 0);
        min = min == Integer.MAX_VALUE ? -1 : min;
        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void comb(int[][] lab, int start, int depth) {
        if(depth == M) {
            bfs(lab);
        }
        for(int i=start; i<N*N; i++) {
            int x = i/N;
            int y = i%N;
            if(lab[x][y] == 2) {
                lab[x][y] = 3;
                comb(lab, i+1, depth+1);
                lab[x][y] = 2;
            }
        }
    }

    private static void bfs(int[][] lab) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int[][] virus = new int[N][N];
        Queue<Position> que = new LinkedList<>();
        for(int i=0; i<N; i++){
            virus[i] = lab[i].clone();
            for(int j=0; j<N ;j++) {
                if(virus[i][j] == 3) {
                    que.add(new Position(i, j));
                }
            }
        }

        while(!que.isEmpty()) {
            Position cur = que.remove();
            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];
                if(xn < 0 || xn >= N || yn < 0 || yn >= N || virus[xn][yn] == 1) {
                    continue;
                }
                if(virus[xn][yn] < 3 ){
                    que.add(new Position(xn, yn));
                    virus[xn][yn] = virus[x][y]+1;
                }
            }
        }
        int max = -1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(virus[i][j] == 0) {
                    return;
                }
                if(lab[i][j] == 2) {
                    continue;
                }
                max = Math.max(max, virus[i][j]-3);
            }
        }
        min = Math.min(min, max);
    }
}
