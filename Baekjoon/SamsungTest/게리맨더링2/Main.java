package 게리맨더링2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] population;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        population = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb();
        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void comb() {
        for(int d1=1; d1<N; d1++){
            for(int d2=1; d2<N; d2++) {
                for(int x=0; x<N; x++) {
                    for(int y=0; y<N; y++) {
                        if(y-d1<0 ||x+d2 >= N || y+d2 >= N|| x+d1+d2 >=N) continue;
                        area(d1,d2,x,y);
                    }
                }
            }
        }
    }

    private static void area(int d1, int d2, int x, int y) {
        int[][] city = new int[N][N];

        for(int i=0; i<=d1; i++) {
            city[x+i][y-i] = 5;
            city[x+d2+i][y+d2-i] = 5;
        }
        for(int i=0; i<=d2; i++){
            city[x+i][y+i] = 5;
            city[x+d1+i][y-d1+i] = 5;
        }

        for(int i=0; i<N; i++) {
            boolean five = false;
            for(int j=0; j<N; j++){
                if(city[i][j] == 5) {
                    if(i == x || i == x+d1+d2){
                        continue;
                    }
                    five = !five;
                    continue;
                }
                if(five){
                    city[i][j] = 5;
                    continue;
                }
                if(i < x+d1 && j <= y) {
                    city[i][j] = 1;
                }else if(i <= x+d2 && j >= y ){
                    city[i][j] = 2;
                }else if(i >= x+d1 && j < y-d1+d2){
                    city[i][j] = 3;
                }else if(i > x+d2 && j >= y-d1+d2){
                    city[i][j] = 4;
                }
            }

        }

        int[] counting = new int[5];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                counting[city[i][j]-1] += population[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<5; i++) {
            max = Math.max(max, counting[i]);
            min = Math.min(min, counting[i]);
        }
        res = Math.min(res, max-min);
    }
}
