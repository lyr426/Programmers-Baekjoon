package 안전영역;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int N;
    public static int[][] area;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        int maxHeight = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] >= maxHeight){
                    maxHeight = area[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int height=0; height<maxHeight; height++) {
            boolean[][] visit = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(area[i][j] <= height) {
                        visit[i][j] = true;
                        continue;
                    }
                    if(!visit[i][j]) {
                        bfs(visit, height, i, j);
                        cnt+=1;
                    }
                }
            }
            if(cnt >= max) {
                max = cnt;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    private static void bfs(boolean[][] visit, int height, int x, int y) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            x = pair.x;
            y = pair.y;

            for(int i=0; i<4; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];

                if(xn >= 0 && xn <N && yn >= 0 && yn < N){
                    if(area[xn][yn] > height && !visit[xn][yn]){
                        queue.add(new Pair(xn, yn));
                    }
                    visit[xn][yn] = true;
                }
            }

        }
    }
}
