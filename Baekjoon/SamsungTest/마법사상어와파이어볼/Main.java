package 마법사상어와파이어볼;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class FireBall{
    int m; //질량
    int s; //속도
    int d; //방향

    FireBall(int m, int s, int d){
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<FireBall>[][] board = boardMaker();

        for(int i=0; i<M; i++) {
            String[] strArray = br.readLine().split(" ");
            int[] input = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
            board[input[0]-1][input[1]-1].add(new FireBall(input[2], input[3], input[4]));
        }

        for(int i=0; i<K; i++){
            board = moveFireBall(board);
            eventFireBall(board);
        }

        int sumM = sumMass(board);
        bw.write(String.valueOf(sumM));;
        bw.flush();
    }

    private static int sumMass(List<FireBall>[][] board) {
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                int t = 0;
                while(board[i][j].size() > t) {
                    FireBall fireBall = board[i][j].get(t);
                    sum += fireBall.m;
                    t+=1;
                }
            }
        }

        return sum;
    }

    private static List<FireBall>[][] boardMaker() {
        List<FireBall>[][] board = new List[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                board[i][j] = new ArrayList<>();
            }
        }
        return board;
    }

    private static List<FireBall>[][] moveFireBall(List<FireBall>[][] board) {
        List<FireBall>[][] newBoard = boardMaker();
        int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                while (board[i][j].size() != 0) {
                    FireBall fireBall = board[i][j].remove(0);
                    int xn = i + dx[fireBall.d] * fireBall.s;
                    int yn = j + dy[fireBall.d] * fireBall.s;
                    xn = xn >= N ? xn % N :xn;
                    xn = xn % N < 0 ?  xn % N + N : xn % N;
                    yn = yn >= N ? yn % N :yn;
                    yn = yn % N < 0 ?  yn % N + N : yn % N;

                    newBoard[xn][yn].add(fireBall);
                }
            }
        }
        return newBoard;
    }

    private static void eventFireBall(List<FireBall>[][] board) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j].size() < 2) {
                    continue;
                }
                int sumM = 0;
                int sumS = 0;
                int dir = 0;
                int size = board[i][j].size();
                while(board[i][j].size() != 0) {
                    FireBall fireBall = board[i][j].remove(0);
                    sumM += fireBall.m;
                    sumS += fireBall.s;
                    dir += fireBall.d % 2;
                }
                sumM = sumM/5;
                if(sumM == 0 ) continue;
                sumS = sumS/size;
                int[] dirs = ( dir == 0 || dir == size) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7} ;
                for(int k=0; k<4; k++){
                    board[i][j].add(new FireBall(sumM,  sumS, dirs[k]));
                }
            }
        }
    }
}
