package 코드트리빵;
import java.io.*;
import java.util.*;

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int M;
    static int finish = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][N];
        Position[] cvs = new Position[M];
        Position[] people = new Position[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            cvs[i] = new Position(x, y);
        }
        int minute = 1;
        while (finish < M) {
            // move People
            movePeople(cvs, people, area);

            if (minute <= M) {
                goBasecamp(cvs, people, area, minute - 1);
            }
            minute += 1;
        }
        bw.write(String.valueOf(minute - 1));
        bw.flush();
    }

    private static void movePeople(Position[] cvs, Position[] people, int[][] area) {

        for (int i = 0; i < M; i++) {
            if (people[i] == null) continue;
            int targetX = cvs[i].x;
            int targetY = cvs[i].y;
            int x = people[i].x;
            int y = people[i].y;
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < 4; j++) {
                int xn = x + dx[j];
                int yn = y + dy[j];
                if (xn < 0 || xn >= N || yn < 0 || yn >= N || area[xn][yn] < 0) continue;
                int dist = bfs(new Position(xn, yn), cvs[i], area);
                if (dist < minDist) {
                    minDist = dist;
                    people[i] = new Position(xn, yn);
                }

            }
        }

        for (int i = 0; i < M; i++) {
            if (people[i] == null) continue;
            int targetX = cvs[i].x;
            int targetY = cvs[i].y;
            int x = people[i].x;
            int y = people[i].y;

            if (x == targetX && y == targetY) {
                people[i] = null;
                area[targetX][targetY] = -1;
                finish += 1;
            }
        }

    }

    private static void goBasecamp(Position[] cvs, Position[] people, int[][] area, int number) {

        int targetX = cvs[number].x;
        int targetY = cvs[number].y;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] != 1 || minDist < Math.abs(targetX - i) + Math.abs(targetY - j)) continue;
                int dist = bfs(new Position(i, j), cvs[number], area);
                if (dist < minDist) {
                    people[number] = new Position(i, j);
                    minDist = dist;
                }
            }
        }
        area[people[number].x][people[number].y] = -1;
    }

    private static int bfs(Position go, Position target, int[][] area) {

        boolean[][] visit = new boolean[N][N];

        Queue<Position> que = new LinkedList<>();
        que.add(go);
        visit[go.x][go.y] = true;
        int count = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Position cur = que.remove();
                if (cur.x == target.x && cur.y == target.y) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int xn = cur.x + dx[i];
                    int yn = cur.y + dy[i];
                    if (xn < 0 || xn >= N || yn < 0 || yn >= N || area[xn][yn] < 0 || visit[xn][yn]) continue;
                    que.add(new Position(xn, yn));
                    visit[xn][yn] = true;
                }
            }
            count++;
        }
        return Integer.MAX_VALUE;
    }
}
