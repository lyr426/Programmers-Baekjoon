package 어른상어;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Shark{
    int smell;
    int num;

    Shark(int smell, int num){
        this.smell = smell;
        this.num = num;
    }
}

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
    static int K;
    static int[] sharkDir;
    static int[][][] priorityDir;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 격자 크기
        int M = Integer.parseInt(st.nextToken()); // 상어 마릿수
        K = Integer.parseInt(st.nextToken()); // 냄새 유지시간

        Shark[][] sea = new Shark[N][N];
        sharkDir = new int[M+1];
        priorityDir = new int[M][4][4];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) continue;
                sea[i][j] = new Shark(K,  num);
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=M; i++) {
            sharkDir[i] = Integer.parseInt(st.nextToken())-1;
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<4; j++) {
                st = new StringTokenizer(br.readLine(), " " );
                for(int k=0; k<4; k++) {
                    priorityDir[i][j][k] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        int res = 0;

        while (res <= 1000) {

            if(check(sea)){
                break;
            }

            HashMap<Integer, Position> map = new HashMap<>();
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    if(sea[i][j] == null || sea[i][j].smell != K) continue;
                    int dir = move(sea, i, j);
                    sharkDir[sea[i][j].num] = dir;
                    int xn = i + dx[dir];
                    int yn = j + dy[dir];
                    map.put(sea[i][j].num, new Position(xn, yn));
                }
            }

            for(int num : map.keySet()){
                Position position = map.get(num);
                if(sea[position.x][position.y] != null && sea[position.x][position.y].num < num) continue;
                sea[position.x][position.y] = new Shark(K+1, num);
            }

            smellRemove(sea);
            res += 1;
        }

        res = res > 1000 ? -1 : res;
        bw.write(String.valueOf(res));
        bw.flush();

    }

    private static boolean check(Shark[][] sea) {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(sea[i][j] == null ) continue;
                if(sea[i][j].num != 1 && sea[i][j].smell == K) return false;
            }
        }

        return true;
    }

    private static int move(Shark[][] sea, int x, int y) {
        int dir = 0;
        int num = sea[x][y].num;

        for(int i=0; i<4; i++){
            int dn = priorityDir[num-1][sharkDir[num]][i];

            int xn = x + dx[dn];
            int yn = y + dy[dn];

            if(xn >= 0 && xn < N && yn >= 0 && yn < N && sea[xn][yn] == null ) {
                return dn;
            }
        }
        for(int i=0; i<4; i++){
            int dn = priorityDir[num-1][sharkDir[num]][i];
            int xn = x + dx[dn];
            int yn = y + dy[dn];

            if(xn >= 0 && xn < N && yn >= 0 && yn < N && sea[xn][yn] != null && sea[xn][yn].num == num ) {
                return dn;
            }
        }
        return dir;
    }

    private static void smellRemove(Shark[][] sea) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(sea[i][j] == null) continue;
                sea[i][j].smell -= 1;
                if(sea[i][j].smell == 0) {
                    sea[i][j] = null;
                }
            }
        }

    }

}
