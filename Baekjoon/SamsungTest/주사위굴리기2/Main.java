package 주사위굴리기2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x = 0;
        int y = 0;
        int dir = 0;
        int[] dice = {6, 3, 4, 5, 2, 1};
        int score = 0;

        while(K-- > 0) {
            x = x + dx[dir];
            y = y + dy[dir];

            if(x < 0 || x >= N || y < 0 || y >= M) {
                x = x - dx[dir];
                y = y - dy[dir];
                dir = dir < 2 ? (dir + 1)%2 : (dir == 2) ? 3 : 2;
                K += 1;
                continue;
            }

            switch (dir) {
                case 0 : dice = new int[]{dice[1], dice[5], dice[0], dice[3], dice[4], dice[2]};
                    break;
                case 1 : dice = new int[]{dice[2], dice[0], dice[5], dice[3], dice[4], dice[1]};
                    break;
                case 2 : dice = new int[]{dice[3], dice[1], dice[2], dice[5], dice[0], dice[4]};
                    break;
                case 3 : dice = new int[]{dice[4], dice[1], dice[2], dice[0], dice[5], dice[3]};
                    break;
            }
            int A = dice[0];
            int B = board[x][y];
            if(A > B) {
                dir = dir < 2 ? (dir + 2) : (dir == 2) ? 1 : 0;
            }else if(A < B) {
                dir = dir < 2 ? (dir == 0 ? 3 : 2 ) : (dir + 2) % 4;
            }
            boolean[][] visit = new boolean[N][M];
            score += getScore(board, visit, x, y) * board[x][y];
        }


        bw.write(String.valueOf(score));
        bw.flush();
    }

    private static int getScore(int[][] board, boolean[][] visit, int x, int y) {
        int N = board.length;
        int M = board[0].length;
        int score = 1;
        if(visit[x][y]) return 0;
        visit[x][y] = true;

        for(int i=0; i<4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn < 0 || xn >= N || yn < 0 || yn >= M || visit[xn][yn] || board[x][y] != board[xn][yn]){
                continue;
            }

            score += getScore(board, visit, xn, yn);
        }

        return score;
    }
}
