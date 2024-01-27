package 상어초등학교;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] position = new int[N][N];
        int[] score = {0, 1, 10, 100, 1000};
        int answer = 0;
        HashSet<Integer>[] favorite = new HashSet[N*N+1];

        for(int i=0; i<N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int studentNum = Integer.parseInt(st.nextToken());
            favorite[studentNum] = new HashSet<>();
            for(int j=0; j<4; j++) {
                favorite[studentNum].add(Integer.parseInt(st.nextToken()));
            }
            positioning(studentNum, position, favorite[studentNum]);
        }

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                int favoriteNum = 0;
                for(int k=0; k<4; k++) {
                    int xn = i + dx[k];
                    int yn = j + dy[k];
                    if (xn < 0 || xn >= N || yn < 0 || yn >= N) {
                        continue;
                    }
                    if(favorite[position[i][j]].contains(position[xn][yn])){
                        favoriteNum += 1;
                    }
                }
                answer += score[favoriteNum];
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void positioning(int studentNum, int[][] position, HashSet favorite){
        int len = position.length;
        int x = -1;
        int y = -1;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int maxEmpty = -1;
        int maxFavorite = -1;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(position[i][j] != 0){
                    continue;
                }
                int emptyCnt = 0;
                int favoriteCnt = 0;
                for(int k=0; k<4; k++) {
                    int xn = i + dx[k];
                    int yn = j + dy[k];
                    if(xn < 0 || xn >= len || yn < 0 || yn >= len) {
                        continue;
                    }
                    if(position[xn][yn] == 0) emptyCnt++;
                    if(favorite.contains(position[xn][yn])) favoriteCnt++;
                }
                if( favoriteCnt > maxFavorite || (favoriteCnt == maxFavorite && emptyCnt > maxEmpty)){
                    maxFavorite = favoriteCnt;
                    maxEmpty = emptyCnt;
                    x = i;
                    y = j;
                }
            }
        }
        position[x][y] = studentNum;
    }
}
