package 연결요소의개수;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        list = (ArrayList<Integer>[]) new ArrayList[N];
        for(int i=0; i<N; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int source = Integer.parseInt(st.nextToken())-1;
            int target = Integer.parseInt(st.nextToken())-1;
            list[source].add(target);
            list[target].add(source);
        }
        int cnt = 0;
        for (int i=0; i<N; i++){
            if(!visit[i]) {
                dfs(i);
                cnt += 1;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }

    private static void dfs(int num) {
        visit[num] = true;
        for(int x: list[num]) {
            if(!visit[x]) dfs(x);
        }
    }
}
