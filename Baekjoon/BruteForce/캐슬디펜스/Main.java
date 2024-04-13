package 캐슬디펜스;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int D;
    static int archer = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) archer += 1;
            }
        }
        boolean[] visit = new boolean[M];
        bruteForce(board, 0, 0, visit);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void bruteForce(int[][] board, int depth, int idx, boolean[] visit) {

        if(depth == 3) {
            compute(board);
//            print(board);
            return;
        }

        for(int i=idx; i<M; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            board[N][i] = 2;
            bruteForce(board, depth+1, i, visit);
            board[N][i] = 0;
            visit[i] = false;
        }

    }

    private static void print(int[][] board) {
        for(int i=0; i<=N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void compute(int[][] board) {
        int[][] newBoard = new int[N+1][M];
        for(int i=0; i<=N; i++) {
            newBoard[i] = board[i].clone();
        }
        int archerCnt = archer;
        int output = 0;

        while (archerCnt > 0) {
//            print(newBoard);
            int idx = 0;

            int[] targetX = {-1, -1, -1};
            int[] targetY = {-1, -1, -1};
            for (int i = 0; i < M; i++) {
                if (newBoard[N][i] != 2) continue;
                int min = Integer.MAX_VALUE;
                for (int p = N - 1; p >= 0; p--) {
                    for (int q = 0; q < M; q++) {
                        if (newBoard[p][q] == 1) {
                            int dist = Math.abs(N - p) + Math.abs(i - q);
                            if(dist == min && q > targetY[idx]){
                                continue;
                            }
                            if (dist <= min && dist <= D ) {
                                min = dist;
                                targetX[idx] = p;
                                targetY[idx] = q;
                            }
                        }
                    }
                }
                if (min < Integer.MAX_VALUE) {
                    idx += 1;

                }
            }

            for (int i = 0; i < 3; i++) {
//                System.out.println(targetX[i] + " ___ " + targetY[i]);
                if (targetX[i] == -1 && targetY[i] == -1) continue;
                if (newBoard[targetX[i]][targetY[i]] == 1) {
                    archerCnt -= 1;
                    output += 1;
                }
                newBoard[targetX[i]][targetY[i]] = 0;
            }
//            print(newBoard);

            for (int i=N-1; i>=0; i--){
                for(int j=0; j<M; j++) {
                    if(newBoard[i][j] == 0) continue;
                    if(i == N-1) {
                        newBoard[i][j] = 0;
                        newBoard[N][j] = 0;
                        archerCnt -= 1;
                        continue;
                    }
                    newBoard[i][j] = 0;
                    newBoard[i+1][j] = 1;
                }
            }
        }

        if(output >= max){
            max = output;
        }
//        print(newBoard);
    }
}
