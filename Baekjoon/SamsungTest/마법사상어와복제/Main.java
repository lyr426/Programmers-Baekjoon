package 마법사상어와복제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    static int N = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] smell = new int[N][N];
        List<Integer>[][] fish = addList();
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
            System.out.println(i + " 번째 =============");
            List<Integer>[][] clonedFish = cloneFish(fish);
            System.out.println("현재 물고기 갯수 : " + allFish(fish));
            System.out.println("*움직이기 전 위치 별 물고기 개수*");
            for(int p=0; p<N; p++){
                for(int q=0; q<N; q++){
                    System.out.print(fish[p][q].size()+ " ");
                }
                System.out.println();
            }
            System.out.println();
            fish = moveFish(fish, smell, sharkX, sharkY);
            System.out.println("*움직인 후 위치 별 물고기 개수*");
            for(int p=0; p<N; p++){
                for(int q=0; q<N; q++){
                    System.out.print(fish[p][q].size()+ " ");
                }
                System.out.println();
            }
            System.out.println();

            Position position = moveShark(fish, smell, sharkX, sharkY);
            System.out.println("상어가 먹고 난 후 물고기 갯수 : " + allFish(fish));
            sharkX = position.x;
            sharkY = position.y;
            smellDecrease(smell);
            fishClone(fish, clonedFish);
            System.out.println("물고기 복제 후 : " + allFish(fish));
        }

        int cnt = allFish(fish);
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int allFish(List<Integer>[][] fish) {
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cnt += fish[i][j].size();
            }
        }

        return cnt;
    }

    private static void fishClone(List<Integer>[][] fish, List<Integer>[][] clonedFish) {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                while (!clonedFish[i][j].isEmpty()) {
                    int dir = clonedFish[i][j].remove(0);
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

    private static Position moveShark(List<Integer>[][] fish, int[][] smell, int sharkX, int sharkY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        System.out.println("현재 상어 위치 => x :" + sharkX + " y : " + sharkY);
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
        System.out.println("잡힌 물고기 : " + maxCnt);

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

    private static int fishCnt(List<Integer>[][] fish, int sharkX, int sharkY, int[] dirs) {
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

    private static List<Integer>[][] addList() {
        List<Integer>[][] fish = new List[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                fish[i][j] = new ArrayList<>();
            }
        }
        return fish;
    }

    private static List<Integer>[][] moveFish(List<Integer>[][] fish, int[][] smell, int sharkX, int sharkY) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        List<Integer>[][] tmpFish = addList();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                while (!fish[i][j].isEmpty()){
                    int dir = fish[i][j].remove(0);
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

    private static List<Integer>[][] cloneFish(List<Integer>[][] fish) {
        List<Integer>[][] output = new List[N][N];
//        for(int i=0; i<N; i++) {
//            output[i] = fish[i].clone();
//        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                output[i][j] = new ArrayList<>(fish[i][j]);
            }
        }

        return output;
    }
}
