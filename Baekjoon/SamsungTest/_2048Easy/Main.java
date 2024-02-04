package _2048Easy;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        bruteforce(board, 0);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void bruteforce(int[][] board, int depth) {
        if(depth == 5) {
            maxNum(board);
            return;
        }

        for(int i=0; i<4; i++) {
            int[][] movedBlock = blockMove(board, i);
            bruteforce(movedBlock, depth+1);
        }
    }

    private static void maxNum(int[][] board) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] >= max){
                    max = board[i][j];
                }
            }
        }
    }

    private static int[][] copyArray(int[][] board) {
        int[][] array = new int[N][N];
        for(int i=0; i<N; i++) {
            array[i] = board[i].clone();
        }
        return array;
    }

    private static int[][] blockMove(int[][] board, int operation) {
        int[][] copyBoard = copyArray(board);

        if(operation == 0 || operation == 2) {
            for (int i = 0; i < N; i++) {
                Deque<Integer> que = new LinkedList<>();
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    flag = blockAdd(que, operation == 0 ? board[j][i] : board[i][j], flag);
                }
                for(int j=0; j<N; j++) {
                    if(operation == 0) {
                        copyBoard[j][i] = !que.isEmpty() ? que.removeFirst() : 0;
                        continue;
                    }
                    copyBoard[i][j] = !que.isEmpty() ? que.removeFirst() : 0;
                }
            }
        }
        if(operation == 1 || operation == 3){
            for (int i = 0; i < N; i++) {
                Deque<Integer> que = new LinkedList<>();
                boolean flag = false;
                for(int j=N-1; j>=0; j--) {
                    flag = blockAdd(que, operation == 1 ? board[j][i] : board[i][j], flag);
                }
                for(int j=N-1; j>=0; j--) {
                    if(operation == 1) {
                        copyBoard[j][i] = !que.isEmpty() ? que.removeFirst() : 0;
                        continue;
                    }
                    copyBoard[i][j] = !que.isEmpty() ? que.removeFirst() : 0;
                }
            }
        }

        return copyBoard;
    }

    private static boolean blockAdd(Deque<Integer> que, int value, boolean flag) {
        if(value == 0 ) {
            return flag;
        }
        if(!que.isEmpty() && que.peekLast() == value && !flag){
            que.add(que.removeLast() * 2);
            return true;
        }
        que.add(value);
        return false;
    }
}
