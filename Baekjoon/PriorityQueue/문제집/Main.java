package 문제집;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N+1];
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
        int[] degree = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            degree[second] += 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            if(degree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int output = queue.poll();
            bw.write(String.valueOf(output)+ " ");
            for(int k : graph[output]){
                degree[k] -= 1;
                if(degree[k] == 0){
                    queue.add(k);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
