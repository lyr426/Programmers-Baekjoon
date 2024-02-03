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
        int[][] copyBoard = copyArray(board);
        blockUp(copyBoard);
        bruteforce(copyBoard, depth+1);

        copyBoard = copyArray(board);
        blockDown(copyBoard);
        bruteforce(copyBoard, depth+1);

        copyBoard = copyArray(board);
        blockLeft(copyBoard);
        bruteforce(copyBoard, depth+1);

        copyBoard = copyArray(board);
        blockRight(copyBoard);
        bruteforce(copyBoard, depth+1);
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

    private static void blockUp(int[][] board) {
        for(int i=0; i<N; i++) {
            Queue<Integer> que = new LinkedList<>();
            boolean flag = false;
            for(int j=0; j<N; j++) {
                if(board[j][i] == 0 ) {
                    continue;
                }
                if(!que.isEmpty() && que.peek() == board[j][i] && !flag){
                    flag = true;
                    que.add(que.remove() * 2);
                    continue;
                }
                que.add(board[j][i]);
                flag = false;
            }

            for(int j=0; j<N; j++) {
                if(!que.isEmpty()){
                    board[j][i] = que.remove();
                    continue;
                }
                board[j][i] = 0;
            }
        }
    }

    private static void blockDown(int[][] board) {
        for(int i=0; i<N; i++) {
            Queue<Integer> que = new LinkedList<>();
            boolean flag = false;
            for(int j=N-1; j>=0; j--) {
                if(board[j][i] == 0 ) {
                    continue;
                }
                if(!que.isEmpty() && que.peek() == board[j][i] && !flag){
                    flag = true;
                    que.add(que.remove() * 2);
                    continue;
                }
                que.add(board[j][i]);
                flag = false;
            }

            for(int j=N-1; j>=0; j--) {
                if(!que.isEmpty()){
                    board[j][i] = que.remove();
                    continue;
                }
                board[j][i] = 0;
            }
        }
    }

    private static void blockLeft(int[][] board) {
        for(int i=0; i<N; i++) {
            Queue<Integer> que = new LinkedList<>();
            boolean flag = false;
            for(int j=0; j<N; j++) {
                if(board[i][j] == 0 ) {
                    continue;
                }
                if(!que.isEmpty() && que.peek() == board[j][i] && !flag){
                    flag = true;
                    que.add(que.remove() * 2);
                    continue;
                }
                que.add(board[i][j]);
                flag = false;
            }

            for(int j=0; j<N; j++) {
                if(!que.isEmpty()){
                    board[i][j] = que.remove();
                    continue;
                }
                board[i][j] = 0;
            }
        }
    }

    private static void blockRight(int[][] board) {
        for(int i=0; i<N; i++) {
            Queue<Integer> que = new LinkedList<>();
            boolean flag = false;
            for(int j=N-1; j>=0; j--) {
                if(board[i][j] == 0 ) {
                    continue;
                }
                if(!que.isEmpty() && que.peek() == board[j][i] && !flag){
                    flag = true;
                    que.add(que.remove() * 2);
                    continue;
                }
                que.add(board[i][j]);
                flag = false;
            }

            for(int j=N-1; j>=0; j--) {
                if(!que.isEmpty()){
                    board[i][j] = que.remove();
                    continue;
                }
                board[i][j] = 0;
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
