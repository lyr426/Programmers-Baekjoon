package 집합의표현;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] set;

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        for(int i=0; i<=N; i++) set[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bufferedReader.readLine(), " ");
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( operator == 0 ){
                union(a,b);
                continue;
            }
            if( operator == 1){
                if(find(a) == find(b)){
                    bufferedWriter.write("YES\n");
                }else {
                    bufferedWriter.write("NO\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;

        if(a > b){
            set[a] = b;
        }else {
            set[b] = a;
        }
    }

    private static int find(int a) {
        if(set[a] == a) return a;
        set[a] = find(set[a]);
        return find(set[a]);
    }
}
