package 적록색약;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static String[][] region;
    static boolean[][] visit;

    private static int rgb(int type) {
        visit = new boolean[N][N];
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    cnt++;
                    bfs(new Pair(i,j),type);
                }
            }
        }
        return cnt;
    }

    private static void bfs(Pair pair, int type) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        visit[pair.x][pair.y] = true;

        while (!queue.isEmpty()){
            pair = queue.remove();
            int x = pair.x;
            int y = pair.y;

            for (int i=0; i<4; i++){
                int xn = x + dx[i];
                int yn = y + dy[i];

                if(xn >= 0 && xn < N && yn >= 0 && yn <N){
                    if(!visit[xn][yn] && region[x][y].equals(region[xn][yn])){
                        queue.add(new Pair(xn, yn));
                        visit[xn][yn] = true;
                    }
                }
            }
            if(region[x][y].equals("R")){
                region[x][y] = "G";
            }
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        region = new String[N][N];

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++){
                region[i][j] = str[j];
            }
        }

        int result1 = rgb(0);
        int result2 = rgb(1);

        bw.write(String.valueOf(result1+" " + result2));
        bw.flush();
        bw.close();
    }

}

