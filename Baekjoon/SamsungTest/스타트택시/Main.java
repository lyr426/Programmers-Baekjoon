package 스타트택시;

import java.io.*;
import java.util.*;

class Position implements Comparable<Position>{
    int x;
    int y;
    int depth;

    Position(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }


    @Override
    public int compareTo (Position o) {
        if(this.depth == o.depth){
            if(this.x == o.x){
                return this.y <= o.y ? -1 : 1;
            }
            return this.x <= o.x ? -1 : 1;
        }
        return this.depth <= o.depth ? -1 : 1;
    }
}
public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] == 1) {
                    area[i][j] = -1;
                }
            }
        }

        HashMap<Integer, Position> destination = new HashMap<>();
        for(int i=0; i<=M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            if(i == 0 ){
                destination.put(0, new Position(x, y, 0));
                continue;
            }
            area[x][y] = i;
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            destination.put(i, new Position(x, y,0));
        }

        for(int i=0; i<M; i++){
            PriorityQueue<Position> queue = new PriorityQueue<>();
//            Queue<Position> que = new LinkedList<>();
            queue.add(destination.get(0)); // 택시위치
            fuel = move(queue, area, destination, fuel);
            if(fuel < 0) {
                break;
            }
        }

        bw.write(String.valueOf(fuel));
        bw.flush();

    }

    private static int move(PriorityQueue<Position> que, int[][] area,  HashMap<Integer, Position> destination, int fuel) {

        int[] dx = {-1, 0, 0, 1}; // 상 좌 우 하
        int[] dy = {0, -1, 1, 0};
        boolean[][] visit = new boolean[N][N];
        Queue<Position> destQueue = new LinkedList<>();
        Position cur = que.peek();

        while(!que.isEmpty()){
            cur = que.remove();
            visit[cur.x][cur.y] = true;
            if(area[cur.x][cur.y] > 0) {
                destQueue.add(new Position(cur.x, cur.y, 0));
                fuel -= cur.depth;
                break;
            }

            for(int i=0; i<4; i++) {
                int xn = cur.x + dx[i];
                int yn = cur.y + dy[i];

                if(xn < 0 || xn >= N || yn < 0 || yn >= N || visit[xn][yn] || area[xn][yn] == -1){
                    continue;
                }
                visit[xn][yn] = true;
                que.add(new Position(xn, yn, cur.depth + 1));
            }
        }

        if(fuel < 0 || destQueue.isEmpty()) {
            return -1;
        }
//        System.out.println("cur :" + area[cur.x][cur.y]);
        cur = destQueue.peek();

        Position target = destination.get(area[cur.x][cur.y]);
        int targetX = target.x;
        int targetY = target.y;
        area[cur.x][cur.y] = 0;
        visit = new boolean[N][N];
//        System.out.println("target" + targetX + "_" + targetY);

        while (!destQueue.isEmpty()) {
            cur = destQueue.remove();
            visit[cur.x][cur.y] = true;
            if(cur.x == targetX && cur.y == targetY){
                if(fuel - cur.depth < 0) {
                    return -1;
                }
                destination.put(0, new Position(cur.x, cur.y, 0));
                return fuel + cur.depth;

            }
            for(int i=0; i<4; i++) {
                int xn = cur.x + dx[i];
                int yn = cur.y + dy[i];

                if(xn < 0 || xn >= N || yn < 0 || yn >= N || visit[xn][yn] || area[xn][yn] == -1){
                    continue;
                }
                visit[xn][yn] = true;
                destQueue.add(new Position(xn, yn, cur.depth + 1));
            }

        }

        return -1;
    }
}
