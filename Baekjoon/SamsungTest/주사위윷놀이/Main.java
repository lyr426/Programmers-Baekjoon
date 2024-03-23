package 주사위윷놀이;

import java.io.*;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board = {{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0},
                         {10, 13, 16, 19},
                         {20, 22, 24},
                         {30, 28, 27, 26},
                         {25, 30, 35, 40, 0}};

        Position[] horse = new Position[4];
        for(int i=0; i<4; i++) horse[i] = new Position(0, 0);

        int[] move = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<10; i++){
            move[i] = Integer.parseInt(st.nextToken());
        }

        moving(board, horse, move, 0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void moving(int[][] board, Position[] horse, int[] move, int score, int depth) {
        if(depth == 10) {
            max = Math.max(max, score);
            return;
        }

        for(int i=0; i<4; i++) {
            Position cur = horse[i];
            int x = cur.x;
            int y = cur.y;
            if(x > 0 && x<4 && y + move[depth] >= board[x].length) {
                x = 4;
                y = move[depth] - (board[cur.x].length - cur.y);
            }else {
                y = cur.y + move[depth] >= board[cur.x].length ? board[cur.x].length - 1 : cur.y + move[depth]; // 도착 칸을 넘어서면 도착 칸에 정지
            }
            if(board[x][y] % 10 == 0 && board[x][y] != 40 && x == 0){ // 10, 20, 30 칸에 멈춰선다면
                x = board[x][y]/10;
                y = 0;
            }
            if(check(board, horse, i, x, y)){ // 움직일 칸에 다른 말이 없다면
                horse[i] = new Position(x, y);
                moving(board, horse, move, score + board[x][y], depth+1);
                horse[i] = cur;
            }
        }

    }

    private static boolean check(int[][] board, Position[] horse, int target, int x, int y) {
        if(board[x][y] == 0) return true;

        for(int i=0; i<4; i++) {
            if(i == target) {
                continue;
            }
            if ((horse[i].x == x && horse[i].y == y) ||(board[x][y]== 40 && board[horse[i].x][horse[i].y] == 40)){
                return false;
            }
        }
        return true;
    }
}
