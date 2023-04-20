package 알고스팟;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x;
    int y;
    int cnt;

    Pair(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pair o) {
        return this.cnt <= o.cnt ? -1 : 1;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // 세로
        int N = Integer.parseInt(st.nextToken()); // 가로
        int[][] maze = new int[N][M];
        int[][] visit = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = Character.getNumericValue(str.charAt(j));
                visit[i][j] = -1;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // priorityqueue 로 만들어서 pair에 부순 개수의 값을 넣어 그 값이 더 적은 큐부터 꺼내어 탐색 ㅎ !!!!

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(0, 0, 0));
        visit[0][0] = 0;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int curX = pair.x;
            int curY = pair.y;

            for(int i=0; i<4; i++){
                int xn = curX + dx[i];
                int yn = curY + dy[i];

                if(xn >= 0 && xn < N && yn >= 0 && yn < M){
                    if(visit[xn][yn] == -1 ){
                        queue.add(new Pair(xn, yn, pair.cnt + maze[xn][yn]));
                        visit[xn][yn] = pair.cnt + maze[xn][yn];
                    }
                }
            }

        }
        bw.write(String.valueOf(visit[N-1][M-1]));
        bw.flush();
        bw.close();


    }
}
