package 회장뽑기;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] friends;
    static int N;

    private static int bfs(int target) {

        int cnt = 0;
        boolean[] visit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        visit[target] = true;
        queue.add(target);

        while (!queue.isEmpty()){
            target = queue.remove();
            boolean flag = false;
            for(int x: friends[target]){
                if(visit[x]) continue;
                queue.add(x);
                visit[x] = true;
                flag = true;
            }
            if(flag) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] res = new int[N];
        friends = new ArrayList[N];
        for(int i=0; i<N; i++) friends[i] = new ArrayList<>();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            if (from == -2 && to == -2) break;
            friends[from].add(to);
            friends[to].add(from);
        }

        int min = N;
        ArrayList<Integer> minList = new ArrayList<>();

        for (int i=0; i<N; i++){
            res[i] = bfs(i);
            if(res[i] == min){
                minList.add(i+1);
            }
            if(res[i] < min){
                min = res[i];
                minList.clear();
                minList.add(i+1);
            }
        }
        bw.write(String.valueOf(min + " " + minList.size()) + "\n");
        for(int x : minList) bw.write(String.valueOf(x+" "));

        bw.flush();
        bw.close();
    }

}
