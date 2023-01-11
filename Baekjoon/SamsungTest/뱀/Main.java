package 뱀;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] apple = new int[N][N];
        boolean[][] snake = new boolean[N][N];
        int K = Integer.parseInt(bufferedReader.readLine());
        for (int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            apple[row-1][col-1] = 1;
        }

        Deque<Pair> deque = new LinkedList<>();
        int L = Integer.parseInt(bufferedReader.readLine());

        int time = 1;
        int curDir = 0; //우 하 좌 상
        deque.addFirst(new Pair(0,0));
        snake[0][0] = true;
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            while(time <= sec || i == L-1){
                Pair curPosition = deque.peekLast();
                if(time-1 == sec && i==L-1){
                    curDir = getDirect(dir, curDir);
                }
                if(curDir == 0) deque.addLast(new Pair(curPosition.x, curPosition.y+1));
                if(curDir == 1) deque.addLast(new Pair(curPosition.x+1, curPosition.y));
                if(curDir == 2) deque.addLast(new Pair(curPosition.x, curPosition.y-1));
                if(curDir == 3) deque.addLast(new Pair(curPosition.x-1, curPosition.y));


                curPosition = deque.peekLast();
                if(curPosition.x >= N || curPosition.x < 0 || curPosition.y >= N || curPosition.y < 0){ // 뱀이 바깥을 벗어나는 경우
                    i = L;
                    break; // 첫 번째 반복문이 끝나야 함
                }
                if(snake[curPosition.x][curPosition.y] == true){ // 뱀이 자신의 몸에 닿을 경우
                    i = L;
                    break;
                }

                if(apple[curPosition.x][curPosition.y] == 0){ // 사과가 없을 경우 꼬리가 잘림
                    Pair popPosition = deque.removeFirst();
                    snake[popPosition.x][popPosition.y] = false;
                }

                snake[curPosition.x][curPosition.y] = true;
                apple[curPosition.x][curPosition.y] = 0;
                time += 1;
            }
            curDir = getDirect(dir, curDir);
        }

        bufferedWriter.write(String.valueOf(time));
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    private static int getDirect(String dir, int curDir) {
        curDir = dir.equals("L")?curDir-1:curDir+1;
        curDir = curDir < 0 ? curDir = 3 : curDir;
        curDir = curDir > 3 ? curDir = 0 : curDir;

        return curDir;
    }
}
