package 나무재테크;

import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[][] land = new PriorityQueue[N][N];
        int[][] addNutriment = new int[N][N];
        int[][] nutriment = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                addNutriment[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = new PriorityQueue<>();
            }
            Arrays.fill(nutriment[i], 5);
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            land[x-1][y-1].add(z);
        }
        for(int i=0; i<K; i++){
            int[][] tree = spring(land, nutriment);
            summerWinter(nutriment, tree);
            fall(land);
            summerWinter(nutriment, addNutriment);
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer += land[i][j].size();
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int[][] spring(PriorityQueue<Integer>[][] land, int[][] nutriment) {
        int[][] tree = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                List<Integer> list = new ArrayList<>();
                while(!land[i][j].isEmpty()){
                    int age = land[i][j].remove();
                    if(nutriment[i][j] >= age){
                        nutriment[i][j] -= age;
                        list.add(age+1);
                    }else {
                        tree[i][j] += age/2;
                    }
                }
                land[i][j].addAll(list);
            }
        }
        return tree;
    }

    private static void summerWinter(int[][] nutriment, int[][] tree) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                nutriment[i][j] += tree[i][j];
            }
        }
    }

    private static void fall(PriorityQueue<Integer>[][] land) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Iterator<Integer> iterator = land[i][j].iterator();
                int cnt = 0;
                while(iterator.hasNext()){
                    if(iterator.next() % 5 == 0){
                        cnt += 1;
                    }
                }
                if(cnt == 0){
                    continue;
                }
                for(int k=0; k<8; k++){
                    int xn = i + dx[k];
                    int yn = j + dy[k];
                    if(xn < 0 || xn >= N || yn < 0 || yn >= N){
                        continue;
                    }
                    int treeCnt = 0;
                    while(treeCnt++<cnt) {
                        land[xn][yn].add(1);
                    }
                }
            }
        }
    }
}
