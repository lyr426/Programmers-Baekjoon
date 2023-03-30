package 미세먼지안녕;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] room = new int[R][C];
        int cleaner = -1; // => Room [cleaner][0]
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1 && cleaner == -1) cleaner = i;
            }
        }
        for (int time=0; time<T; time++) {
            int[][] tmp = new int[R][C];
            tmp[cleaner][0] = -1;
            tmp[cleaner+1][0] = -1;
            //확산

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++) {
                    tmp[i][j] += room[i][j];
                    if (room[i][j] < 5) continue;
                    int dust = room[i][j]/5;
                    if(i-1 >= 0 && !(i-1 == cleaner+1 && j==0)) {tmp[i-1][j] += dust; tmp[i][j] -= dust;}    // 상
                    if(i+1 < R && !(i+1 == cleaner && j==0 )) {tmp[i+1][j] += dust; tmp[i][j] -= dust; } //하
                    if(j-1 >= 0 && room[i][j-1] != -1) {tmp[i][j-1] += dust; tmp[i][j] -= dust;} // 좌
                    if(j+1 < C ) {tmp[i][j+1] += dust;  tmp[i][j] -= dust;} // 우

                }
            }

            room = tmp;
            tmp = ArrayCopy(room);
            for (int i=0; i<=cleaner; i++) {
                if(i-1 >= 0){
                    tmp[i][0] = room[i-1][0];
                }
                tmp[i][C-1] = room[i+1][C-1];
            }
            for (int i=cleaner+1; i<R; i++) {
                if(i+1 < R){
                    tmp[i][0] = room[i+1][0];
                }
                tmp[i][C-1] = room[i-1][C-1];
            }
            for(int j=0; j<C; j++){
                if(j+1 < C){
                    tmp[0][j] = room[0][j+1];
                    tmp[R-1][j] = room[R-1][j+1];
                }
                if(j-1 >= 1){
                    tmp[cleaner][j] = room[cleaner][j-1];
                    tmp[cleaner+1][j] = room[cleaner+1][j-1];
                }
            }
            tmp[cleaner][0] = -1;
            tmp[cleaner+1][0] = -1;
            tmp[cleaner][1] = 0;
            tmp[cleaner+1][1] = 0;
            room = tmp;
        }
        int result = 2;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++) {
                result += room[i][j];
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int[][] ArrayCopy(int[][] source) {
        int[][] arr = new int[source.length][source[0].length];
        for(int i=0; i<source.length; i++){
            System.arraycopy(source[i], 0, arr[i], 0, source[0].length);
        }
        return arr;
    }


}
