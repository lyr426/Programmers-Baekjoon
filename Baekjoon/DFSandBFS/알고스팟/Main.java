package 알고스팟;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, 0));
        visit[0][0] = 0;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int curX = pair.x;
            int curY = pair.y;

            for(int i=0; i<3; i++){
                int xn = curX + dx[i];
                int yn = curY + dy[i];

                if(xn >= 0 && xn < N && yn >= 0 && yn <M){
                    if(visit[xn][yn] == -1 || visit[xn][yn] > maze[xn][yn] + visit[curX][curY] ){
                        queue.add(new Pair(xn, yn));
                        visit[xn][yn] = visit[curX][curY] + maze[xn][yn];
                    }
                }
            }

        }
        bw.write(String.valueOf(visit[N-1][M-1]));
        bw.flush();
        bw.close();


    }
}
