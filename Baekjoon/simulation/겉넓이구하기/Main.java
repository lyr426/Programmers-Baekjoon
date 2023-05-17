package simulation.겉넓이구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int figure[][] = new int[N][M];
        int surfaceArea = M*N;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                figure[i][j] = Integer.parseInt(st.nextToken());
                if(i==0 || j ==0) {
                    surfaceArea += figure[i][j];
                }
            }
        }

        surfaceArea += figure[0][0];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if( i > 0) {
                    if (figure[i - 1][j] < figure[i][j]) {
                        surfaceArea += figure[i][j] - figure[i - 1][j];
                    }
                }
                if(j > 0) {
                    if (figure[i][j - 1] < figure[i][j]) {
                        surfaceArea += figure[i][j] - figure[i][j - 1];
                    }
                }
            }
        }

        surfaceArea *= 2;
        bw.write(String.valueOf(surfaceArea));
        bw.flush();
        bw.close();

    }
}
