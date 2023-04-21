package 육각보드;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[][] color = new int[N][N];
        char[][] input = new char[N][N];

        int[] dx = {0, -1, -1, 0, 0, 1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 0};
        for(int i=0; i<N; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                input[i][j] = chars[j];
                if (input[i][j] == '-') continue;
                for(int p=0; p<7; p++){
                    int xn = i + dx[p];
                    int yn = j + dy[p];

                    if(xn >= 0 && xn < N && yn >= 0 && yn < N ){
                        if( input[xn][yn] == 0 || input[xn][yn] != '-' ){
                            color[xn][yn] += 1;
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(input[i][j] == '-') continue;
                if(color[i][j] > max) max = color[i][j];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}


