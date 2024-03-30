package 마법사상어와파이어스톰;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int len;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        len = (int)Math.pow(2, N);

        int[][] area = new int[len][len];

        for(int i=0; i<len; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<len; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            area = fireStorm(area, len, L);
        }

        boolean[][] visit = new boolean[len][len];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                sum += area[i][j];
                if(!visit[i][j] && area[i][j] > 0) {
                    Queue<Position> que = new LinkedList<>();
                    que.add(new Position(i, j));
                    visit[i][j] = true;
                    max = Math.max(max, bfs(que, visit, area));
                }
            }
        }
        max = sum == 0 ? 0 : max;
        bw.write(sum + "\n" + max);
        bw.flush();
    }

    private static int dfs(int x, int y, boolean[][] visit, int[][] area) {

        visit[x][y] = true;
        for(int i=0; i<4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn < 0 || xn >= len || yn < 0 || yn >= len || area[xn][yn] == 0 || visit[xn][yn]) {
                continue;
            }
            return 1 + dfs(xn, yn, visit, area);
        }

        return 0;
    }

    private static int bfs(Queue<Position> que, boolean[][] visit, int[][] area) {

        int cnt = 0;
        while (!que.isEmpty()){
            Position cur = que.poll();
            cnt += 1;
            for(int i=0; i<4; i++) {
                int xn = cur.x + dx[i];
                int yn = cur.y + dy[i];
                if(xn < 0 || xn >= len || yn < 0 || yn >= len || area[xn][yn] == 0 || visit[xn][yn]) {
                    continue;
                }
                que.add(new Position(xn, yn));
                visit[xn][yn] = true;
            }
        }
        return cnt;
    }

    private static int[][] fireStorm(int[][] area, int len, int L) {

        int size = (int)Math.pow(2, L);
        int repeat = (len*len)/(size*size);
        int[][] newArea = copyArea(area);
        for(int i=0; i<repeat; i++) {
            int x = ((size * i) / len) * size;
            int y = (size * i) % len;
            rotate(area, newArea, x, y, size);
        }

        newArea = minusIce(newArea);
        return newArea;
    }

    private static int[][] minusIce(int[][] area) {
        int[][] newArea = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                int cnt = 0;
                if(area[i][j] == 0) {
                    continue;
                }
                for(int k=0; k<4; k++) {
                    int xn = i + dx[k];
                    int yn = j + dy[k];
                    if(xn < 0 || xn >= len || yn < 0 || yn >= len || area[xn][yn] == 0) {
                        cnt += 1;
                    }
                    newArea[i][j] = cnt >= 2 ? area[i][j] - 1 : area[i][j];
                }
            }
        }
        return newArea;
    }

    private static void rotate(int[][] area, int[][] rotatedArea,int x, int y, int size) {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                rotatedArea[x+j][(y+size)-i-1] = area[x+i][y+j];
            }
        }
    }

    private static int[][] copyArea(int[][] area) {
        int[][] newArea = new int[len][len];

        for(int i=0; i< len; i++) {
            newArea[i] = area[i].clone();
        }
        return newArea;
    }
}
