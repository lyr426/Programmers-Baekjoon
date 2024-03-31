package 상어중학교;

import java.io.*;
import java.util.*;

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class BlockGroup implements Comparable<BlockGroup> {
    int x;
    int y;
    int blockCnt;
    int rainbowCnt;

    BlockGroup(int x, int y, int blockCnt, int rainbowCnt) {
        this.x = x;
        this.y = y;
        this.blockCnt = blockCnt;
        this.rainbowCnt = rainbowCnt;
    }

    @Override
    public int compareTo (BlockGroup o){
        if(this.blockCnt == o.blockCnt) {
            if(this.rainbowCnt == o.rainbowCnt) {
                if(this.x == o.x) {
                    return this.y <= o.y ? 1 : -1;
                }
                return this.x <= o.x ? 1 : -1;
            }
            return this.rainbowCnt <= o.rainbowCnt ? 1 : -1;
        }
        return  this.blockCnt <= o.blockCnt ? 1 : -1;
    }

}

public class Main {

    static int N;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int res = 0;
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
               board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*뭔가 있어야 함 = 반복문 */
        while(true) {
            boolean[][] visit = new boolean[N][N];
            PriorityQueue<BlockGroup> blockGroups = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && board[i][j] > 0) {
                        Queue<Position> que = new LinkedList<>();
                        que.add(new Position(i, j));
                        visit[i][j] = true;
                        makeGroup(que, board, visit, blockGroups);
                    }
                }
            }
            if(blockGroups.isEmpty()) break;
            int score = blockGroups.peek().blockCnt;
            res += (score * score);
            removeBlock(blockGroups, board);
            board = rotateBlock(board);

        }
        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static int[][] rotateBlock(int[][] board) {
        gravity(board);
        int[][] newBoard = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                newBoard[j][i] = board[i][N-j-1];

            }
        }

        gravity(newBoard);
        return newBoard;
    }

    private static void gravity(int[][] board) {

        for(int i=0; i<N; i++) {

            for(int j=N-1; j>0; j--) {
                if(board[j][i] != -2 ) continue;

                for(int p=j-1; p>=0; p--) {
                    if(board[p][i] == -1) break;
                    if(board[p][i] >= 0) {
                        board[j][i] = board[p][i];
                        board[p][i] = -2;
                        break;
                    }
                }
            }
        }

    }


    private static void removeBlock(PriorityQueue<BlockGroup> blockGroups, int[][] board) {
        boolean[][] visit = new boolean[N][N];
        Queue<Position> que = new LinkedList<>();
        BlockGroup block = blockGroups.peek();
        que.add(new Position(block.x, block.y));
        int blockColor = board[block.x][block.y];

        while(!que.isEmpty()) {
            Position cur = que.remove();
            board[cur.x][cur.y] = -2;

            for(int i=0; i<4; i++) {
                int xn = cur.x + dx[i];
                int yn = cur.y + dy[i];

                if(xn < 0 || xn >= N || yn < 0 || yn >= N || visit[xn][yn] ||(board[xn][yn] != 0 && board[xn][yn] != blockColor)){
                    continue;
                }

                que.add(new Position(xn, yn));
                visit[xn][yn] = true;
            }
        }

    }

    private static void makeGroup(Queue<Position> que, int[][] board, boolean[][] visit, PriorityQueue<BlockGroup> blockGroups) {

        Queue<Position> rainbowBlock = new LinkedList<>();
        int blockCnt = 0;
        int rainbowCnt = 0;
        Position mainBlock = que.peek();
        int blockColor = board[mainBlock.x][mainBlock.y];


        while(!que.isEmpty()) {
            Position cur = que.remove();
            blockCnt += 1;
            for(int i=0; i<4; i++) {
                int xn = cur.x + dx[i];
                int yn = cur.y + dy[i];

                if(xn < 0 || xn >= N || yn < 0 || yn >= N || visit[xn][yn] ||(board[xn][yn]!=0 && board[xn][yn] != blockColor)){
                    continue;
                }

                que.add(new Position(xn, yn));
                visit[xn][yn] = true;
                if(board[xn][yn] == 0) {
                    rainbowBlock.add(new Position(xn, yn));
                    rainbowCnt += 1;
                }

            }
        }

        while(!rainbowBlock.isEmpty()) {
            Position cur = rainbowBlock.remove();
            visit[cur.x][cur.y] = false;
        }
        if(blockCnt > 1) {
            blockGroups.add(new BlockGroup(mainBlock.x, mainBlock.y, blockCnt, rainbowCnt));
        }
    }

    private static void print(int[][] board) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
