package 두동전;

import java.io.*;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    private static void bruteForce(Position[] coin, int cnt) {
        if(cnt >= min || cnt >= 10) return;
        int drop = 0;
        for(int i=0; i<2; i++) {
            if(coin[i].x < 0 || coin[i].x >= N || coin[i].y < 0 || coin[i].y >= M){
                drop += 1;
            }
        }
        if(drop == 1) {
            min = Math.min(min, cnt);
            return;
        }else if(drop == 2) return;

        for(int i=0; i<4; i++) {
            Position[] moveCoin = new Position[2];
            for(int j=0; j<2; j++) {
                int xn = coin[j].x + dx[i];
                int yn = coin[j].y + dy[i];
                if(xn < 0 || xn >= N || yn < 0 || yn >= M){
                    moveCoin[j] = new Position(xn, yn);
                    continue;
                }
                moveCoin[j] = board[xn][yn] == 1 ? new Position(coin[j].x, coin[j].y) : new Position(xn, yn);
            }
            bruteForce(moveCoin, cnt +1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        Position[] coin = new Position[2];

        int coinCnt = 0;
        for(int i=0; i<N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(input[j] == '#'){
                    board[i][j] = 1;
                }else if(input[j] == 'o'){
                    coin[coinCnt++] = new Position(i,j);
                }
            }
        }
        bruteForce(coin, 0);
        bw.write(String.valueOf(min >= 10 ? -1 : min ));
        bw.flush();
        bw.close();
    }

}
