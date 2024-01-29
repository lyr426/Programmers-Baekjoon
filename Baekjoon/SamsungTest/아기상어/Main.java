package 아기상어;

import java.io.*;
import java.util.*;


class Position{
    int x;
    int y;
    int distance;

    Position(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        int N = Integer.parseInt(br.readLine());
        int level = 2;
        int fishCnt = 0;
        int answer = 0;
        boolean[][] visit = new boolean[N][N];
        int[][] sea = new int[N][N];
        PriorityQueue<Position> que = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.distance == o2.distance){
                    if(o1.x == o2.x){
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o1.distance - o2.distance;
            }
        });

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9){
                    que.add(new Position(i, j, 0));
                    sea[i][j] = 0;
                }
            }
        }

        while(!que.isEmpty()) {
            Position position = que.remove();
            int x = position.x;
            int y = position.y;
            int distance = position.distance;

            if (sea[x][y] < level && sea[x][y] > 0){
                answer += distance;
                distance = 0;
                fishCnt += 1;
                sea[x][y] = 0;
                if(fishCnt == level) {
                    fishCnt = 0;
                    level += 1;
                }
                visit = new boolean[N][N];
                que.clear();
            }
            visit[x][y] = true;

            for(int i=0; i<4; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];
                if(xn < 0 || xn >= N || yn < 0 || yn >= N){
                    continue;
                }
                if(!visit[xn][yn] && sea[xn][yn] <= level ){
                    que.add(new Position(xn, yn, distance+1));
                    visit[xn][yn] = true;
                }

            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
