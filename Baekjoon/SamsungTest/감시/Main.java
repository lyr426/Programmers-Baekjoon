package 감시;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    static int[][][] type1 = {{{-1, 0}},{{0, -1}},{{0, 1}},{{1, 0}}};
    static int[][][] type2 = {{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}};
    static int[][][] type3 = {{{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}};
    static int[][][] type4 = {{{0, -1}, {-1, 0}, {0, 1}}, {{-1, 0}, {0, 1}, {1, 0}}, {{0, -1}, {0, 1}, {1, 0}}, {{0, -1}, {-1, 0}, {1, 0}}};
    static int[][][] type5 = {{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];

        int x = -1;
        int y = -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " " );
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] > 0 && room[i][j] < 6 && x == -1 && y == -1){
                    x = i;
                    y = j;
                }
            }
        }
        if(x == -1 && y == -1){
            min = checkRoom(room);
        }else {
            bruteForce(room, x, y);
        }
        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void bruteForce(int[][] room, int x, int y) {
        int[][][] type = copyType(room[x][y]);

        for(int i=0; i<type.length; i++){
            int[][] copiedRoom = copyArray(room);
            for(int j=0; j<type[0].length; j++){
                int xn = x;
                int yn = y;
                while (xn >= 0 && xn < N && yn >= 0 && yn < M){
                    if(room[xn][yn] == 6){
                        break;
                    }
                    if(room[xn][yn] == 0) {
                        copiedRoom[xn][yn] = -1;
                    }
                    xn = xn + type[i][j][0];
                    yn = yn + type[i][j][1];
                }
            }

            for(int p=x; p<N; p++){
                for(int q=0; q<M; q++) {
                    if(p==x && q <= y){
                        continue;
                    }
                    if(room[p][q] > 0 && room[p][q] < 6){
                        bruteForce(copiedRoom, p, q);
                    }
                }
            }
            min = Math.min(min, checkRoom(copiedRoom));

        }

    }

    private static int checkRoom(int[][] copiedRoom) {
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copiedRoom[i][j] == 0){
                    cnt +=1;
                }
            }
        }
        return cnt;
    }

    private static int[][][] copyType(int t) {
        switch (t){
            case 1 : return type1;
            case 2 : return type2;
            case 3 : return type3;
            case 4 : return type4;
            default: return type5;
        }
    }

    private static int[][] copyArray(int[][]array) {
        int[][] copiedArray = new int[N][M];
        for(int i=0; i<N; i++){
            copiedArray[i] = array[i].clone();
        }
        return copiedArray;
    }
}
