package 세친구;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int res = Integer.MAX_VALUE;
    static int N;
    static List<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = (ArrayList<Integer>[]) new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for(int i=1; i<=N-2; i++){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(i);
            bruteForce(tmpList, lists[i].size());
        }

        bw.write(String.valueOf(res == Integer.MAX_VALUE ? -1 : res-6));
        bw.flush();
        bw.close();
    }

    private static void bruteForce(List<Integer> tmpList, int sum) {
        int size = tmpList.size();
        if(size == 3) {
            if(res > sum){
                res = sum;
            }
            return;
        }
        int cur = tmpList.get(size-1);
        for (int i=cur+1; i<=N; i++){
            if(!lists[cur].contains(i)) {
                continue;
            }
            if(size == 2 && !lists[tmpList.get(0)].contains(i)){
                continue;
            }
            tmpList.add(i);
            bruteForce(tmpList, sum + lists[i].size());
            tmpList.remove(size);
        }
    }
}
