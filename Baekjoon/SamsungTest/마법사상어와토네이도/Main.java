package 마법사상어와토네이도;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static boolean[][] visit;
    static int[][] sand;
    static int outSand = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visit = new boolean[N][N];
        sand = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j=0; j<N; j++){
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int curX = N/2;
        int curY = N/2;
        int dir = 0;
        int repeat = 1;

        while(curX != 0 || curY != 0) {

            for(int i=0; i<2; i++) {
                for(int j=0; j<repeat; j++) {
                    if(curX <= 0 && curY <= 0) break;
                    tornado(dir, curX, curY);
                    curX += dx[dir];
                    curY += dy[dir];
                }
                dir = (dir + 1) % 4;
            }

            repeat += 1;
        }

        bufferedWriter.write(String.valueOf(outSand));
        bufferedWriter.flush();

    }

    private static void tornado(int dir, int x, int y) {

        int[][] moveX = {{-1, 1, -2, 2, -1, 1, -1, 1, 0},   //좌
                         { 0, 0, 1, 1, 1, 1, 2, 2, 3},      //하
                         {-1, 1, -2, 2, -1, 1, -1, 1, 0},   //우
                         {0, 0, -1, -1, -1, -1, -2, -2, -3} //상
        };
        int[][] moveY = {{0, 0, -1, -1, -1, -1, -2, -2, -3},
                         {-1, 1, -2, 2, -1, 1, -1, 1, 0},
                         {0, 0, 1, 1, 1, 1, 2, 2, 3},
                         {-1, 1, -2, 2, -1, 1, -1, 1, 0}};
        double[] ratio = {0.01, 0.01, 0.02, 0.02, 0.07, 0.07, 0.1, 0.1, 0.05};

        int xn = x + dx[dir];
        int yn = y + dy[dir];
        int curSand = sand[xn][yn];

        for(int i=0; i<9; i++) {
            int curX = x + moveX[dir][i];
            int curY = y + moveY[dir][i];

            int sandRatio = (int)(curSand * ratio[i]);
            sand[xn][yn] -= sandRatio;
            if(curX < 0 || curX >= N || curY < 0 || curY >=N){
                outSand += sandRatio;
                continue;
            }
            sand[curX][curY] += sandRatio;
        }
        int xn2 = xn + dx[dir];
        int yn2 = yn + dy[dir];

        if(xn2 < 0 || xn2 >= N || yn2 < 0 || yn2 >= N) {
            outSand += sand[xn][yn];
            sand[xn][yn] = 0;
            return;
        }
        sand[xn2][yn2] += sand[xn][yn];
        sand[xn][yn] = 0;

    }

    static void print(){
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                System.out.print(sand[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
