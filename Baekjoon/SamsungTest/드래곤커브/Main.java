package 드래곤커브;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int SIZE = 102;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[SIZE][SIZE];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> dir = new ArrayList<>();
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            dir.add(Integer.parseInt(st.nextToken()));
            int g = Integer.parseInt(st.nextToken());
            curve(board, x, y, dir, g, 0);
        }

        int res = square(board);
        bw.write(String.valueOf(res));
        bw.flush();

    }

    private static int square(boolean[][] board) {
        int cnt = 0;
        for(int i=0; i<SIZE-1; i++) {
            for(int j=0; j<SIZE-1; j++) {
                if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]){
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static void curve(boolean[][] board, int x, int y, List<Integer> dirs, int g, int depth) {
        board[x+1][y+1] = true;
        if(depth > g) {
            return;
        }
        for(int i=dirs.size()-1; i>=0 ; i--) {
            int dir = dirs.get(0);
            if(depth > 0) {
                dir = (dirs.get(i) + 1) % 4;
                dirs.add(dir);
            }
            x = x + dx[dir];
            y = y + dy[dir];
            board[x+1][y+1] = true;
        }
        curve(board, x, y, dirs, g, depth + 1);
    }
}
