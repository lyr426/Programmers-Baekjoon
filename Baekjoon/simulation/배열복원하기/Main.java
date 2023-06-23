package 배열복원하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arrB = new int[H+X][W+Y];
        int[][] arrA = new int[H][W];

        for(int i=0; i<H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W+Y; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                arrA[i][j] = arrB[i][j];
                if(i>=X && j>=Y) { // 겹친 부분일 경우
                    arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
                }
                bw.write(String.valueOf(arrA[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
