package 마법사상어와토네이도;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static int N;
    public static boolean[][] visit;
    public static int[][] sand;
    public static int outSand = 0;

    public static void leftTornado(int x, int y){
        int originSand = sand[x][y-1];
        int spreadSand = 0;
        if(y-3 >= 0){
            sand[x][y-3] = sand[x][y-3] + (int)((double)originSand*0.05);
            spreadSand = spreadSand + (int)((double)originSand*0.05);
        }
        if(y-2 >= 0){
            if(x-1>=0){
                sand[x-1][y-2] = sand[x-1][y-2] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
            if(x+1<N){
                sand[x+1][y-2] = sand[x+1][y-2] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
        }
        if(x-2>=0){
            sand[x-2][y-1] = sand[x-2][y-1] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(x+2<N){
            sand[x+2][y-1] = sand[x+2][y-1] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(x-1>=0){
            sand[x-1][y-1] = sand[x-1][y-1] + (int)((double)originSand*0.07);
            sand[x-1][y] = sand[x-1][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        if(x+1<N){
            sand[x+1][y-1] = sand[x+1][y-1] + (int)((double)originSand*0.07);
            sand[x+1][y] = sand[x+1][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        visit[x][y] = true;
        sand[x][y-1] = 0;
        System.out.println("spreadSand = " + spreadSand);
        if(y-2>=0){
            sand[x][y-2] = sand[x][y-2] + (originSand-spreadSand);
        }else{
            outSand = outSand + (originSand-spreadSand);
        }

    }

    public static void upTornado(int x, int y){
        int originSand = sand[x-1][y];
        int spreadSand = 0;
        System.out.println("originSand = " + originSand);
        if(x-3 >= 0){
            sand[x-3][y] = sand[x-3][y] + (int)((double)originSand*0.05);
            spreadSand = spreadSand + (int)((double)originSand*0.05);
        }
        if(x-2 >= 0){
            if(y-1>=0){
                sand[x-2][y-1] = sand[x-2][y-1] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
            if(y+1<N){
                sand[x-2][y+1] = sand[x-2][y+1] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
        }
        if(y-2>=0) {
            sand[x - 1][y - 2] = sand[x - 1][y - 2] + (int) ((double) originSand * 0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(y+2<N){
            sand[x-1][y+2] = sand[x-1][y+2] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(y-1>=0){
            sand[x-1][y-1] = sand[x-1][y-1] + (int)((double)originSand*0.07);
            sand[x][y-1] = sand[x][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        if(y+1<N){
            sand[x-1][y+1] = sand[x+1][y-1] + (int)((double)originSand*0.07);
            sand[x][y+1] = sand[x+1][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        visit[x][y] = true;
        sand[x-1][y] = 0;
        if(x-2>=0){
            sand[x-2][y] = sand[x-2][y] + (originSand-spreadSand);
        }else{
            outSand = outSand + (originSand-spreadSand);
        }
    }

    public static void rightTornado(int x, int y){
        int originSand = sand[x][y+1];
        int spreadSand = 0;
        if(y+3 < N){
            sand[x][y+3] = sand[x][y+3] + (int)((double)originSand*0.05);
            spreadSand = spreadSand + (int)((double)originSand*0.05);
        }
        if(y+2 < N){
            if(x-1>=0){
                sand[x-1][y+2] = sand[x-1][y+2] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
            if(x+1<N){
                sand[x+1][y+2] = sand[x+1][y+2] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.01);
            }
        }
        if(x-2>=0){
            sand[x-2][y+1] = sand[x-2][y+1] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(x+2<N){
            sand[x+2][y+1] = sand[x+2][y+1] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(x-1>=0){
            sand[x-1][y+1] = sand[x-1][y+1] + (int)((double)originSand*0.07);
            sand[x-1][y] = sand[x-1][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        if(x+1<N){
            sand[x+1][y+1] = sand[x+1][y+1] + (int)((double)originSand*0.07);
            sand[x+1][y] = sand[x+1][y] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        visit[x][y] = true;
        sand[x][y+1] = 0;
        if(y+2<N){
            sand[x][y+2] = sand[x][y+2] + (originSand-spreadSand);
        }else{
            outSand = outSand + (originSand-spreadSand);
        }
    }

    public static void downTornado(int x, int y){
        int originSand = sand[x+1][y];
        int spreadSand = 0;
        if(x+3 < N){
            sand[x+3][y] = sand[x+3][y] + (int)((double)originSand*0.05);
            spreadSand = spreadSand + (int)((double)originSand*0.05);
        }
        if(x+2 < N){
            if(y-1>=0){
                sand[x+2][y-1] = sand[x+2][y-1] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
            if(y+1<N){
                sand[x+2][y+1] = sand[x+2][y+1] + (int)((double)originSand*0.1);
                spreadSand = spreadSand + (int)((double)originSand*0.1);
            }
        }
        if(y-2>=0){
            sand[x+1][y-2] = sand[x+1][y-2] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(y+2<N){
            sand[x+1][y+2] = sand[x+1][y+2] + (int)((double)originSand*0.02);
            spreadSand = spreadSand + (int)((double)originSand*0.02);
        }
        if(y-1>=0){
            sand[x+1][y-1] = sand[x+1][y-1] + (int)((double)originSand*0.07);
            sand[x][y-1] = sand[x][y-1] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        if(y+1<N){
            sand[x+1][y+1] = sand[x+1][y+1] + (int)((double)originSand*0.07);
            sand[x][y+1] = sand[x][y+1] + (int)((double)originSand*0.01);
            spreadSand = spreadSand + (int)((double)originSand*0.08);
        }
        visit[x][y] = true;
        sand[x+1][y] = 0;
        if(x+2<N){
            sand[x+2][y] = sand[x+2][y] + (originSand-spreadSand);
        }else{
            outSand = outSand + (originSand-spreadSand);
        }
    }


    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visit = new boolean[N][N];
        sand = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j=0; j<N; j++){
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int direction = 0;
        int x = N/2;
        int y = N/2;

        while(x != 0 || y != 0){
            if(direction == 0) {
                System.out.println("left");
                System.out.println("x = " + x);
                System.out.println("y = " + y);

                leftTornado(x, y);
                y = y-1;
                if(x+1<N && visit[x+1][y]==false){
                    direction = 1;
                }

                for(int i=0; i<N; i++){
                    for (int j=0; j<N; j++){
                        System.out.print(sand[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(direction == 1) {
                System.out.println("down");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                downTornado(x,y);
                x = x+1;
                if(y+1<N && visit[x][y+1]==false){
                    direction = 2;
                }
                for(int i=0; i<N; i++){
                    for (int j=0; j<N; j++){
                        System.out.print(sand[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(direction == 2) {
                System.out.println("right");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                rightTornado(x,y);
                y = y+1;
                if(x-1 >= 0 && visit[x-1][y]==false){
                    direction = 3;
                }
                for(int i=0; i<N; i++){
                    for (int j=0; j<N; j++){
                        System.out.print(sand[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(direction == 3) {
                System.out.println("up");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                upTornado(x, y);
                x = x-1;
                if(y-1>=0 && visit[x][y-1]==false){
                   direction = 0;
                }
                for(int i=0; i<N; i++){
                    for (int j=0; j<N; j++){
                        System.out.print(sand[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        bufferedWriter.write(String.valueOf(outSand));

        bufferedWriter.flush();

    }
}
