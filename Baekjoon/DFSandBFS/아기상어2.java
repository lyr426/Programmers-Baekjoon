import java.util.*;
import java.io.*;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int N, M;
    public static int[][] arr;
    public static int[][] visit;
    public static int[] dx = {-1,-1,-1,0,0,1,1,1};
    public static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static int[][] bfs(Pair pair){
        Queue<Pair> que = new LinkedList<>();
        que.add(pair);
        visit[pair.x][pair.y] = 1;
        while (!que.isEmpty()){
            Pair p = que.remove();
            int x = p.x;
            int y = p.y;
            for(int i=0; i<8; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];
                if (0 <= xn && 0 <= yn && N > xn && M > yn) {
                    if (visit[xn][yn] == 0 || visit[xn][yn]>visit[x][y]+1) {
                        que.add(new Pair(xn, yn));
                        visit[xn][yn] = visit[x][y] + 1;
                    }
                }
            }
        }
        return visit;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(arr[i][j] == 1) {
                    visit = bfs(new Pair(i,j));
                }
            }
        }
        int max = visit[0][0];
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(arr[i][j] == 0 && max<= visit[i][j]) max = visit[i][j];
            }
        }
        bw.write(String.valueOf(max-1));
        bw.flush();
    }
}
public class 아기상어 {
    
}
