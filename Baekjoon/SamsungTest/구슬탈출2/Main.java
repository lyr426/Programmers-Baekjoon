package 구슬탈출2;

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
    public static char[][] board;
    public static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Position red = new Position(0, 0);
        Position blue = new Position(0, 0);

        board = new char[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'R' || board[i][j] == 'B'){
                    red = (board[i][j] == 'R') ? new Position(i, j) : red;
                    blue = (board[i][j] == 'B') ? new Position(i, j) : blue;
                    board[i][j] = '.';
                }
            }
        }
        bruteForce(0, -1, red, blue );
        min = min > 10 ? -1 : min;
        bw.write(String.valueOf(min));
        bw.flush();

    }

    private static void bruteForce(int depth, int dir, Position red, Position blue){
        if(depth > 10 || depth > min){
            return;
        }
        if((red.x == blue.x && ((red.y < blue.y && dir == 0) || (red.y > blue.y && dir == 2)))
                || (red.y == blue.y && ((red.x < blue.x && dir == 1) || (red.x > blue.x && dir == 3)))) {
            red = move(dir, red, blue);
            blue = move(dir, blue, red);
        } else if(dir != -1){
            blue = move(dir, blue, red);
            red = move(dir, red, blue);
        }

        if(board[blue.x][blue.y] == 'O') {
            return;
        }
        if(board[red.x][red.y] == 'O')  {
            min = Math.min(min, depth);
            return;
        }

        Position tmpRed = new Position(red.x, red.y);
        Position tmpBlue = new Position(blue.x, blue.y);

        for(int i=0; i<4; i++) {
            if(dir != i && (dir + i) % 2 == 0 && dir != -1){
                continue;
            }
            bruteForce(depth + 1, i, red, blue);
            red = new Position(tmpRed.x, tmpRed.y);
            blue = new Position(tmpBlue.x, tmpBlue.y);
        }
    }

    private static Position move(int dir, Position ball, Position difBall) {
        int x = ball.x;
        int y = ball.y;
        board[difBall.x][difBall.y] = board[difBall.x][difBall.y] == 'O' ? 'O' : '#';
        switch (dir){
            case 0: { // 좌
                while(board[x][y-1] == '.' || board[x][y-1] == 'O'){
                    y -= 1;
                    if(board[x][y] == 'O'){
                        break;
                    }
                }
                break;
            }
            case 1: { // 상
                while(board[x-1][y] == '.' || board[x-1][y] == 'O'){
                    x -= 1;
                    if(board[x][y] == 'O'){
                        break;
                    }
                }
                break;
            }
            case 2: { // 우
                while(board[x][y+1] == '.' || board[x][y+1] == 'O'){
                    y += 1;
                    if(board[x][y] == 'O'){
                        break;
                    }
                }
                break;
            }
            case 3: { // 하
                while (board[x+1][y] == '.' || board[x+1][y] == 'O') {
                    x += 1;
                    if(board[x][y] == 'O'){
                        break;
                    }
                }
                break;
            }
        }
        if(board[difBall.x][difBall.y] == '#') {
            board[difBall.x][difBall.y] = '.';
        }
        return new Position(x, y);
    }
}
