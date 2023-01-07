package 마법사상어와비바라기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] bucket;
    static boolean[][] cloud;
    static int N;

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bucket = new int[N][N];
        cloud = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j=0; j<N; j++){
                bucket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] active = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bufferedReader.readLine(), " ");
            active[i][0] = Integer.parseInt(st.nextToken())-1; // 방향
            active[i][1] = Integer.parseInt(st.nextToken()); // 크기
        }

        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true; // 초기 비구름 설정

        for(int i=0; i<M; i++){
            moveCloudAndRainy(active[i][0], active[i][1]);
            copyWater();
            makeCloud();
        }

        int res = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                res += bucket[i][j];
            }
        }
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void makeCloud() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(cloud[i][j] == true) {
                    cloud[i][j] = false;
                    continue;
                }
                if(bucket[i][j]>=2){
                    bucket[i][j] -= 2;
                    cloud[i][j] = true;
                }
            }
        }
    }

    private static void copyWater() {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j] == true){
                    for(int k=0; k<4; k++){
                        if(i+dx[k] >= 0 && i+dx[k]<N && j+dy[k] >= 0 && j+dy[k] <N){
                            if(bucket[i+dx[k]][j+dy[k]]>0){
                                bucket[i][j] += 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void moveCloudAndRainy(int dir, int size) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        size = size%N;
        boolean[][] tempCloud = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j] == true) {
                    int x = i + dx[dir] * size;
                    int y = j + dy[dir] * size;
                    if (x < 0) x = N + x;
                    if (x >= N) x = x - N;
                    if (y < 0) y = N + y;
                    if (y >= N) y = y - N;
                    tempCloud[x][y] = true;
                    bucket[x][y] += 1;
                }
            }
        }
        arrayCopy(tempCloud, cloud);
    }

    private static void arrayCopy(boolean[][] tempCloud, boolean[][] cloud) {
        int len = tempCloud.length;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++){
                if(cloud[i][j] == true && tempCloud[i][j] == false){
                    cloud[i][j] = false;
                }
                if(tempCloud[i][j] == true){
                    cloud[i][j] = true;
                }
            }
        }
    }

}
