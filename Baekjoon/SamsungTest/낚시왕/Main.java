package 낚시왕;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Shark{
    int speed;
    int dir;
    int size;

    Shark(int speed, int dir, int size){
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}
public class Main {

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int res = 0;

        Shark[][] sharks = new Shark[R][C];

        for(int i=0; i<M; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sharks[input[0]-1][input[1]-1] = new Shark(input[2], input[3], input[4]);
        }
        for(int i=0; i<C; i++){
            res += fishing(sharks, i);
            move(sharks);
        }

        bw.write(String.valueOf(res));
        bw.flush();

    }

    private static void move(Shark[][] sharks) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Shark[][] newSharks = new Shark[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(sharks[i][j] == null) {
                    continue;
                }
                int x = i;
                int y = j;
                int dir = sharks[i][j].dir;
                int speed = sharks[i][j].speed;
                while(speed--> 0){
                    if((x == 0 && dir == 1) || (x == R-1 && dir == 2)){
                        dir = dir == 1 ? 2 : 1;
                    }

                    if((y == 0 && dir == 4) || (y == C-1 && dir == 3) ){
                        dir = dir == 3 ? 4 : 3;
                    }
                    x = x + dx[dir-1];
                    y = y + dy[dir-1];
                }
                if(newSharks[x][y] != null && newSharks[x][y].size > sharks[i][j].size ){
                    continue;
                }
                newSharks[x][y] = new Shark(sharks[i][j].speed, dir, sharks[i][j].size);
            }
        }
        for(int i=0; i<R; i++){
            sharks[i] = newSharks[i].clone();
        }
    }

    private static int fishing(Shark[][] sharks, int position) {

        for(int i=0; i<R; i++) {
            if(sharks[i][position]!=null){
                int x = sharks[i][position].size;
                sharks[i][position] = null;
                return x;
            }
        }

        return 0;
    }
}
