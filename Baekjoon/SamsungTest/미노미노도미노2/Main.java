package 미노미노도미노2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] blue = new boolean[6][4];
    static boolean[][] green = new boolean[6][4];
    static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            switch (t) {
                case 1 :
                    obo(x, y);
                    break;
                case 2 :
                    obt(x, y);
                    break;
                case 3 :
                    tbo(x, y);
                    break;
            }
            addScore();
            drop();

        }
        int cnt = 0;
        for(int i=0; i<6 ; i++) {
            for(int j=0; j<4; j++) {
                if(blue[i][j]){
                    cnt += 1;
                }
                if(green[i][j]) {
                    cnt += 1;
                }
            }
        }
        bw.write(score + "\n" + cnt);
        bw.flush();
    }

    private static void print() {
        System.out.println("-----blue----");

        for(int i=0; i<6; i++) {
            for(int j=0; j<4; j++) {
                char c = blue[i][j] ? 'O' : 'X';
                System.out.print(c+" ");
            }
            System.out.println();
        }
       System.out.println("-----green----");

        for(int i=0; i<6; i++) {
            for(int j=0; j<4; j++) {
                char c = green[i][j] ? 'O' : 'X';
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }


    private static void addScore() {

        for(int i=0; i<6; i++){
            boolean greenFlag = true;
            boolean blueFlag = true;
            for(int j=0; j<4; j++) {
                if(!green[i][j]){
                    greenFlag = false;
                }
                if(!blue[i][j]){
                    blueFlag = false;
                }
            }
            if(greenFlag){
                for(int j=i; j>0; j--) {
                    green[j] = green[j-1].clone();
                }
                score += 1;
            }
            if(blueFlag){
                for(int j=i; j>0; j--) {
                    blue[j] = blue[j-1].clone();
                }
                score += 1;
            }
        }


    }

    private static void drop() {
        int greenCnt = 0;
        int blueCnt = 0;

        for(int i=0; i<2; i++){
            for(int j=0; j<4; j++){
              if(green[i][j]){
                  greenCnt += 1;
                  break;
              }
            }
            for(int j=0; j<4; j++){
                if(blue[i][j]){
                    blueCnt += 1;
                    break;
                }
            }
        }

        for(int i=5; i>1; i--) {
            green[i] = green[i-greenCnt].clone();
        }
        for(int i=5; i>1; i--) {
            blue[i] = blue[i-blueCnt].clone();
        }
        for(int i=0; i<2; i++) {
            green[i] = new boolean[4];
            blue[i] = new boolean[4];
        }
    }

    private static void obo(int x, int y) { //one by one
        int blueX = 0;
        while( blueX < 6 && !blue[blueX][3-x]) {
            blueX += 1;
        }
        blue[blueX-1][3-x] = true;

        int greenX = 0;
        while (greenX < 6 && !green[greenX][y]){
            greenX += 1;
        }
        green[greenX-1][y] = true;
    }

    private static void obt(int x, int y) {

        int blueX = 1;
        while (blueX<6 && !blue[blueX][3-x]){
            blueX += 1;
        }
        blue[blueX-1][3-x] = true;
        blue[blueX-2][3-x] = true;

        int greenX = 0;
        while (greenX < 6 && !green[greenX][y] && !green[greenX][y+1]){
            greenX += 1;
        }
        green[greenX-1][y] = true;
        green[greenX-1][y+1] = true;

    }
    private static void tbo(int x, int y) {

        int blueX = 0;
        while(blueX < 6 && !blue[blueX][3-x] && !blue[blueX][3-x-1]){
            blueX += 1;
        }
        blue[blueX-1][3-x] = true;
        blue[blueX-1][3-x-1] = true;

        int greenX = 1;
        while (greenX < 6 && !green[greenX][y]){
            greenX += 1;
        }
        green[greenX-1][y] = true;
        green[greenX-2][y] = true;
    }
}
