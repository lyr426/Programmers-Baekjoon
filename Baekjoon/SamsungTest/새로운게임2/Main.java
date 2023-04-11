package com.example.demo2.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Horse{
    int dir;
    int x;
    int y;
    Horse( int x, int y, int dir){
        this.dir = dir;
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int[] dx = {0, 0, 0, -1, 1};
    public static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        Horse[] horses = new Horse[K];
        ArrayList<Integer>[][] lists = new ArrayList[N][N];

        for (int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                lists[i][j] = new ArrayList<>();
            }
        }

        for (int i=0; i<K; i++){
            int[] tmp = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            horses[i] = new Horse(tmp[0]-1, tmp[1]-1, tmp[2]);
            lists[tmp[0]-1][tmp[1]-1].add(i);
        }


        int result = 0;
        boolean flag = false;
        while (result <= 1000) {
            result += 1;
            for(int i=0; i<K; i++) {
                int dir = horses[i].dir;
                int x = horses[i].x + dx[dir];
                int curX = horses[i].x;
                int y = horses[i].y + dy[dir];
                int curY = horses[i].y ;
                int block = 2; // 범위에 벗어나면 파란색 경우
                if(x >= 0 && x < N && y >= 0 && y < N) { // 범위에 포함되는 경우
                    block = board[x][y];
                }
                if(block == 2 ) {
                    dir = dir < 3 ? dir % 2 + 1 : 4 % dir + 3;
                    horses[i].dir = dir;
                    x = horses[i].x + dx[dir];
                    y = horses[i].y + dy[dir];

                    if (x >= 0 && x < N && y >= 0 && y < N) { // 범위에 포함되는 경우
                        block = board[x][y];
                    } else {
                        continue;
                    }
                }

                if( block == 0) { // 앞으로 가야할 방향이 흰색인 경우
                    int idx = lists[curX][curY].indexOf(i);
                    int len = lists[curX][curY].size();
                    for(int p = idx ; p < len; p++) {
                        int moveHorse = lists[curX][curY].remove(idx);
                        lists[x][y].add(moveHorse);
                        horses[moveHorse].x = x;
                        horses[moveHorse].y = y;
                    }
                } else if (block == 1){ // 빨간색인 경우
                    int idx = lists[curX][curY].indexOf(i);
                    for(int p = lists[curX][curY].size()-1 ; p >= idx; p--) {
                        int moveHorse = lists[curX][curY].remove(p);
                        lists[x][y].add(moveHorse);
                        horses[moveHorse].x = x;
                        horses[moveHorse].y = y;
                    }
                }
                if(lists[x][y].size() >= 4) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;

        }
        result = result > 1000 ? -1 : result;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
