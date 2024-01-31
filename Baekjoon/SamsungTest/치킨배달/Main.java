package 치킨배달;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        HashSet<Pair> set = new HashSet<>();
        comb(city, set, 0, 0);
        bw.write(String.valueOf(min));
        bw.flush();
    }

    static void comb(int[][] city, HashSet<Pair> set, int start, int depth) {
        if(depth == M) {
            min = Math.min(min, chicken(city, set));
            return;
        }
        for(int i=start; i <N*N; i++){
            int x = i / N;
            int y = i % N;
            if(city[x][y] == 2){
                Pair pair = new Pair(x, y);
                set.add(pair);
                comb(city, set,i+1, depth+1);
                set.remove(pair);
            }
        }
    }

    static int chicken(int[][] city, HashSet<Pair> set) {
        int distance = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(city[i][j] != 1) {
                    continue;
                }
                Iterator<Pair> iterator = set.iterator();
                int minDistance = Integer.MAX_VALUE;
                while (iterator.hasNext()){
                    Pair pair = iterator.next();
                    int res = Math.abs(i- pair.x) + Math.abs(j-pair.y);
                    minDistance = Math.min(minDistance, res);
                }
                distance += minDistance;
            }
        }
        return distance;
    }
}
