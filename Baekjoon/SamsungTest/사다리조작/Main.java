package 사다리조작;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int H;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boolean[][] ladder = new boolean[H][N];
        boolean[][] visit = new boolean[H][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a-1][b-1] = true;
        }
        bruteForce(ladder, 0, 0,-1);
        min = min > 3 ? -1 : min;
        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void bruteForce(boolean[][] ladder, int depth, int x, int y) {
        if(depth > 3) {
            return;
        }
        if(check(ladder)){
            min = Math.min(min, depth);
            return;
        }

        for(int i=x; i<H; i++) {
            for(int j=0; j<N-1; j++) {
                if(i==x && j <= y) continue;
                if(!ladder[i][j]){
                    if((j>0 && ladder[i][j-1])){
                        continue;
                    }
                    ladder[i][j] = true;
                    bruteForce(ladder, depth+1, i, j);
                    ladder[i][j] = false;
                }
            }
        }
    }

    private static boolean check(boolean[][] ladder) {

        for(int i=0; i<N; i++){
            int x = 0;
            int y = i;
            while(x != H){
                if(y>0 && ladder[x][y-1]){
                    y -= 1;
                }else if (ladder[x][y]){
                    y += 1;
                }
                x += 1;
            }
            if(i != y) {
                return false;
            }
        }
        return true;
    }
}
