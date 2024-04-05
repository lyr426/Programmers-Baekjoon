package 마법사상어와복제;

import java.io.*;
import java.util.*;


class Position{
    int x;
    int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] smell = new int[N][N];
        Queue<Integer>[][] fish = addList();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            fish[x][y].add(dir);
        }
        st = new StringTokenizer(br.readLine()," ");
        int sharkX = Integer.parseInt(st.nextToken())-1;
        int sharkY = Integer.parseInt(st.nextToken())-1;

        for(int i=0; i<S; i++) {
            Queue<Integer>[][] clonedFish = cloneFish(fish);
            fish = moveFish(fish, smell, sharkX, sharkY);
            Position position = moveShark(fish, smell, sharkX, sharkY);
            sharkX = position.x;
            sharkY = position.y;
            smellDecrease(smell);
            fishClone(fish, clonedFish);
        }

        int cnt = allFish(fish);
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int allFish(Queue<Integer>[][] fish) {
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cnt += fish[i][j].size();
            }
        }

        return cnt;
    }

    private static void fishClone(Queue<Integer>[][] fish, Queue<Integer>[][] clonedFish) {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                while (!clonedFish[i][j].isEmpty()) {
                    int dir = clonedFish[i][j].remove();
                    fish[i][j].add(dir);
                }
            }
        }
    }

    private static void smellDecrease(int[][] smell) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(smell[i][j]>0){
                    smell[i][j] -= 1;
                }
            }
        }
    }

    private static Position moveShark(Queue<Integer>[][] fish, int[][] smell, int sharkX, int sharkY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int[] max = {0, 0, 0};
        int maxCnt = Integer.MIN_VALUE;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++) {
                for(int k=0; k<4; k++){
                    int[] dirs = {i ,j, k};
                    int cnt = fishCnt(fish, sharkX, sharkY, dirs);

                    if(cnt > maxCnt) {
                        maxCnt = cnt;
                        max = dirs.clone();
                    }
                }
            }
        }

        for(int i=0; i<3; i++) {
            sharkX += dx[max[i]];
            sharkY += dy[max[i]];

            if(fish[sharkX][sharkY].size() > 0) {
                smell[sharkX][sharkY] = 3;
            }
            fish[sharkX][sharkY].clear();
        }
        return new Position(sharkX, sharkY);
    }

    private static int fishCnt(Queue<Integer>[][] fish, int sharkX, int sharkY, int[] dirs) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int cnt = 0;
        boolean[][] visit = new boolean[N][N];

        for(int i=0; i<3; i++) {
            sharkX += dx[dirs[i]];
            sharkY += dy[dirs[i]];
            if(sharkX < 0 || sharkX >= N || sharkY < 0 || sharkY >= N){
                return -1;
            }
            if(!visit[sharkX][sharkY]) {
                cnt += fish[sharkX][sharkY].size();
            }
            visit[sharkX][sharkY] = true;
        }

        return cnt;
    }

    private static Queue<Integer>[][] addList() {
        Queue<Integer>[][] fish = new Queue[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                fish[i][j] = new LinkedList<>();
            }
        }
        return fish;
    }

    private static Queue<Integer>[][] moveFish(Queue<Integer>[][] fish, int[][] smell, int sharkX, int sharkY) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        Queue<Integer>[][] tmpFish = addList();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                while (!fish[i][j].isEmpty()){
                    int dir = fish[i][j].remove();
                    boolean flag = false;
                    for(int k=0; k<8; k++){
                        int tmpDir = dir - k < 0 ? dir - k + 8 : dir - k;
                        int xn = i + dx[tmpDir];
                        int yn = j + dy[tmpDir];
                        if(xn < 0 || xn >= N || yn < 0 || yn >= N || (xn == sharkX && yn == sharkY) || smell[xn][yn] > 0) {
                            continue;
                        }
                        tmpFish[xn][yn].add(tmpDir);
                        flag = true;
                        break;
                    }
                    if(!flag) {
                        tmpFish[i][j].add(dir);
                    }
                }
            }
        }

        return tmpFish;
    }

    private static Queue<Integer>[][] cloneFish(Queue<Integer>[][] fish) {
        Queue<Integer>[][] output = new Queue[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                output[i][j] = new LinkedList<>(fish[i][j]);
            }
        }

        return output;
    }
}
