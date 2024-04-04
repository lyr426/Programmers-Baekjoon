package 온풍기안녕;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;
    int dir;

    Position(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
class Wall{
    double x;
    double y;

    Wall(double x, double y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int[][] dx = {{-1, 0, 1}, {-1, 0, 1}, {-1, -1, -1}, {1, 1, 1}}; // 우, 좌, 상, 하
    static int[][] dy = {{1, 1, 1}, {-1, -1, -1}, {-1, 0, 1}, {-1, 0, 1}};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] area = new int[R][C];
        HashSet<Position> heaters = new HashSet<>();
        HashSet<Position> checkPosition = new HashSet<>();
        HashSet<Wall> walls = new HashSet<>();

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 5) {
                    checkPosition.add(new Position(i, j, 0));
                    continue;
                }
                if(num > 0) {
                    heaters.add(new Position(i, j, num-1));
                }
            }
        }
        int W = Integer.parseInt(br.readLine());
        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine()," ");
            double x = Integer.parseInt(st.nextToken())-1;
            double y = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            if(t == 0) {
                x -= 0.5;
            }
            if(t == 1) {
                y += 0.5;
            }
            walls.add(new Wall(x, y));
        }
        int chocolate = 0;

        while (chocolate <= 100) {
            heating(area, heaters, walls);
            System.out.println("heating=====");
            print(area);
            System.out.println("control Temp ======");
            controlTemp(area, walls);
            print(area);

            System.out.println("outside Temp =======");
            outsideTemp(area);
            print(area);

            chocolate += 1;
            if(check(checkPosition, area, K)){
                break;
            }
        }

        bw.write(String.valueOf(chocolate));
        bw.flush();
    }

    private static void print(int[][] area) {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(area[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(HashSet<Position> checkPosition, int[][] area, int K) {

        for(Position position : checkPosition) {
            int x  = position.x;
            int y = position.y;
            if(area[x][y] < K) return false;
        }

        return true;
    }

    private static void outsideTemp(int[][] area) {

        for(int i=0; i<R; i++) {
            if(area[i][0] > 0) area[i][0] -= 1;
            if(area[i][C-1] > 0) area[i][C-1] -=1;
        }

        for(int j=1; j<C-1; j++) {
            if(area[0][j] > 0) area[0][j] -=1;
            if(area[R-1][j] > 0) area[R-1][j] -= 1;
        }

    }

    private static void controlTemp(int[][] area, HashSet<Wall> walls) {
        int[][] temp = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if( j+1 < C && wallCheck(0, i, j+1, walls) && area[i][j] != area[i][j+1]){
                    int num = Math.abs(area[i][j] - area[i][j+1]) / 4;
                    temp[i][j] = area[i][j] > area[i][j + 1] ? temp[i][j] - num : temp[i][j] + num;
                    temp[i][j + 1] = area[i][j] > area[i][j + 1] ? temp[i][j + 1] + num : temp[i][j + 1] - num;
                }

                if( i+1 < R && wallCheck(3, i+1, j, walls) && area[i][j] != area[i+1][j]){
                    int num = Math.abs(area[i][j] - area[i+1][j]) / 4;
                    temp[i][j] = area[i][j] > area[i + 1][j] ? temp[i][j] - num : temp[i][j] + num;
                    temp[i+1][j] = area[i][j] > area[i + 1][j] ? temp[i + 1][j] + num : temp[i + 1][j] - num;
                }
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                area[i][j] = area[i][j] + temp[i][j];
            }
        }

    }

    private static void heating(int[][] area, HashSet<Position> heaters, HashSet<Wall> walls) {

        for(Position heater : heaters) {
            boolean[][] visit = new boolean[R][C];
            int dir = heater.dir;
            int xn = heater.x + dx[dir][1];
            int yn = heater.y + dy[dir][1];
            visit[xn][yn] = true;
            dfs(area, visit, xn, yn, walls, dir, 5);
        }
    }

    private static void dfs(int[][] area, boolean[][] visit, int x, int y, HashSet<Wall> walls, int dir, int depth) {
        area[x][y] += depth;
        if(depth == 1) {
            return;
        }

        for(int i=0; i<3; i++) {
            int xn = x + dx[dir][i];
            int yn = y + dy[dir][i];
            if(xn < 0 || xn >= R || yn < 0 || yn >= C || visit[xn][yn] || !wallCheck(dir, xn, yn, walls)){
                continue;
            }
            visit[xn][yn] = true;
            dfs(area, visit, xn, yn, walls, dir, depth - 1);
        }
    }

    private static boolean wallCheck(int dir, double x, double y, HashSet<Wall> walls) {

        x = (dir > 1) ? (dir == 2 ? x + 0.5 : x - 0.5) : x;
        y = (dir < 2) ? (dir == 0 ? y - 0.5 : y + 0.5) : y;

        for(Wall wall : walls) {
            if(wall.x == x && wall.y == y) {
                return false;
            }
        }

        return true;
    }
}
