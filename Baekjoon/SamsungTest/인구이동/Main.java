package 인구이동;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] population;
    static int[][] union;

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        union = new int[N][N];
        int cnt = -1;
        int result = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j=0; j<N; j++){
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(cnt != 1 && cnt != N*N){
            cnt = comparePeople();
            movePeople(cnt);
            union = new int[N][N];
            result += 1;
        }
        if(cnt == N*N) result -= 1;

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void movePeople(int cnt) {

        for (int i=1; i<=cnt; i++){
            int sum = 0;
            int country = 0;
            for(int j=0; j<N; j++){
                for (int k=0; k<N; k++){
                    if(union[j][k] == i) {
                        sum += population[j][k];
                        country += 1;
                    }
                }
            }
            int newPopulation = sum / country;
            for(int j=0; j<N; j++){
                for (int k=0; k<N; k++){
                    if(union[j][k] == i) {
                        population[j][k] = newPopulation;
                    }
                }
            }
        }

    }

    private static int comparePeople() {
        int cnt = 0;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(union[i][j] == 0){
                    dfs(i, j, ++cnt);
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, int cnt) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        union[x][y] = cnt;
        for(int i=0; i<4; i++){
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn>=0 && xn<N && yn>=0 && yn<N){
                int abs = Math.abs(population[x][y] - population[xn][yn]);
                if(abs >= L && abs <= R && union[xn][yn] == 0){
                    dfs(xn,yn,cnt);
                }
            }
        }
    }
}
