package 청소년상어;

import java.io.*;
import java.util.StringTokenizer;

class Fish{
    int num;
    int dir;

    Fish(int num, int dir){
        this.num = num;
        this.dir = dir;
    }
}

class Position{
    int x;
    int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Fish[][] area = new Fish[4][4];
        int sum = 0;

        for(int i=0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++) {
                if(i == 0 && j == 0) {
                    sum += Integer.parseInt(st.nextToken());
                    area[i][j] = new Fish(0, Integer.parseInt(st.nextToken())-1);
                    continue;
                }
                area[i][j] = new Fish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
            }
        }
        sharkMove(area, sum, 0, 0);
        bw.write(String.valueOf(max));
        bw.flush();

    }

    private static void sharkMove(Fish[][] area, int sum, int x, int y) {

        Fish shark = area[x][y];
        max = Math.max(max, sum);


        for(int i=1; i<=16; i++) {
            Position target = getPosition(area, i);
            if(target == null) {
                continue;
            }
            Fish fish = area[target.x][target.y];
            int xn = target.x + dx[fish.dir];
            int yn = target.y + dy[fish.dir];
            while (xn < 0 || xn >= 4 || yn  < 0 || yn >= 4 || (xn == x && yn == y)){
                fish.dir = (fish.dir + 1)%8;
                xn = target.x + dx[fish.dir];
                yn = target.y + dy[fish.dir];
            }
            Fish tmp = area[target.x][target.y];
            area[target.x][target.y] = area[xn][yn];
            area[xn][yn] = tmp;
        }

        for(int i=1; i<4; i++){
            int xn = x + (dx[shark.dir] * i);
            int yn = y + (dy[shark.dir] * i);

            if(xn < 0 || xn >= 4 || yn < 0 || yn >= 4 || area[xn][yn].num <= 0) {
                continue;
            }
            Fish[][] newArea = copyArea(area);
            newArea[xn][yn].num = 0;
            newArea[x][y] = new Fish(0, 0);

            sharkMove(newArea, sum + area[xn][yn].num, xn, yn);
        }

    }

    private static void print(Fish[][] area) {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(area[i][j].num+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static Fish[][] copyArea(Fish[][] area) {
        Fish[][] fish = new Fish[4][4];

        for(int i=0; i<4; i++) {
            for(int j=-0; j<4; j++) {
                fish[i][j] = new Fish(area[i][j].num, area[i][j].dir);
            }
        }
        return fish;
    }

    private static Position getPosition(Fish[][] area, int target) {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++){
                if(area[i][j].num == target){
                    return new Position(i, j);
                }
            }
        }
        return null;
    }
}
