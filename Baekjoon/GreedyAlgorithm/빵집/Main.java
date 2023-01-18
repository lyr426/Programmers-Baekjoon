package 빵집;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static boolean[][] pipe;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pipe = new boolean[R][C];

        for(int i=0; i<R; i++){
            String[] arrs = br.readLine().split("");
            for(int j=0; j<C; j++){
                if(arrs[j].equals(".")){
                    pipe[i][j] = true;
                }
            }
        }
        for(int i=0; i<R; i++){
            if(pipe[i][0] == true){
                boolean dfsResult = dfs(i, 0);
                if(dfsResult == true) result += 1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int x, int y) {
        pipe[x][y] = false;
        if(y == C-1) return true;
        for(int i=0; i<3; i++){
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn >= 0 && xn < R && yn >= 0 && yn < C){
                if(pipe[xn][yn] == true){
                    boolean bfsResult = dfs(xn, yn);
                    if(bfsResult == true) return true;
                }
            }
        }
        return false;
    }
}
