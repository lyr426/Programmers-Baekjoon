package 주사위굴리기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0}; // 동 서 북 남
        int[] dice = {0, 0, 0, 0, 0, 0}; // 아랫면, 동, 서, 남, 북, 윗면

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()){
            int operation = Integer.parseInt(st.nextToken());
            int xn = x + dx[operation-1];
            int yn = y + dy[operation-1];

            if(xn < 0 || xn >= N || yn < 0 || yn >= M){
                continue;
            }
            switch (operation) {
                case 1 : // 1 = 동
                    dice = new int[]{dice[1], dice[5], dice[0], dice[3], dice[4], dice[2]};
                    break;
                case 2 : // 2 = 서
                    dice = new int[]{dice[2], dice[0], dice[5], dice[3], dice[4], dice[1]};
                    break;
                case 3: // 3 = 북
                    dice = new int[]{dice[4], dice[1], dice[2], dice[0], dice[5], dice[3]};
                    break;
                case 4: // 4 = 남
                    dice = new int[]{dice[3], dice[1], dice[2], dice[5], dice[0], dice[4]};
                    break;
            }
            if(board[xn][yn] == 0){
                board[xn][yn] = dice[0];
            }else {
                dice[0] = board[xn][yn];
                board[xn][yn] = 0;
            }
            bw.write(String.valueOf(dice[5])+" ");
            x = xn;
            y = yn;
        }
        bw.flush();
    }


//    private int[] roll(int[] board, int[] operation ){
//
//
//        return 0;
//    }
}
