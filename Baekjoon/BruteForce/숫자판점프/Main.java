package 숫자판점프;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N = 5;
    static int[][] board = new int[N][N];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static HashMap<String, Integer> map = new HashMap<>();

    public static void dfs(int x, int y, String s) {
        if(s.length() >= 6) {
            map.put(s, 0);
            return;
        }
        for(int i=0; i<4; i++){
            int xn = x + dx[i];
            int yn = y + dy[i];

            if(xn >= 0 && xn < N && yn >= 0 && yn < N) {
                dfs(xn, yn, s+(board[xn][yn]));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               StringBuilder sb = new StringBuilder();
               dfs(i,j, "");
            }
        }

        bw.write(String.valueOf(map.size()));
        bw.close();
    }
}
